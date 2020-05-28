package com.roctiv.debtcontroll.api.service.Impl;

import com.roctiv.debtcontroll.api.dao.UserDAO;
import com.roctiv.debtcontroll.api.entity.User;
import com.roctiv.debtcontroll.api.exception.LoginNotFoundException;
import com.roctiv.debtcontroll.api.service.UserService;
import com.roctiv.debtcontroll.api.utils.PasswordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
