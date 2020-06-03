package com.roctiv.debtcontroll.api.service.Impl;

import com.roctiv.debtcontroll.api.dao.UserDAO;
import com.roctiv.debtcontroll.api.entity.User;
import com.roctiv.debtcontroll.api.exception.LoginNotFoundException;
import com.roctiv.debtcontroll.api.service.UserService;
import com.roctiv.debtcontroll.api.utils.PasswordUtils;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Map;

import static com.roctiv.debtcontroll.api.security.jwt.SecurityConfig.*;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Override
    public User createUser(User user) {
        user.setPass(PasswordUtils.gerarByCrypt(user.getPass()));
        log.info("Salvando usuario: ", user.getNome());
        return this.userDAO.save(user);
    }

    @Override
    public List<User> listAll() {
        log.info("Buscando todos os usuários.");
        return this.userDAO.listUser();
    }

    @Override
    public User getUser(Long id) {
        return this.userDAO.getUserById(id);
    }

    @Override
    public User login(String username, String pass) throws LoginNotFoundException {
        User user;
        try {
            user = this.userDAO.getUserByUsername(username);
        }
        catch (Exception e){
            throw new LoginNotFoundException("Usuário informado está errado.");
        }
        if (PasswordUtils.isValid(pass,user.getPass()))
            return user;
        else
            throw new LoginNotFoundException("Senha informada está errada.");
    }

    @Override
    public User getUser(Map<String,String> headers) {

        String token = headers.get(HEADER_STRING.toLowerCase());
        if (token == null)
            return null;
        String username = Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(token.replace(TOKEN_PREFIX,""))
                .getBody()
                .getSubject();

        return this.userDAO.getUserByUsername(username);

    }
}
