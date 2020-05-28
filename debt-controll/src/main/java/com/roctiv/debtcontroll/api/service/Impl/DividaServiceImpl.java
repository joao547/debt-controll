package com.roctiv.debtcontroll.api.service.Impl;

import com.roctiv.debtcontroll.api.dao.DividaDAO;
import com.roctiv.debtcontroll.api.dao.UserDAO;
import com.roctiv.debtcontroll.api.entity.Divida;
import com.roctiv.debtcontroll.api.entity.User;
import com.roctiv.debtcontroll.api.model.DividaModel;
import com.roctiv.debtcontroll.api.service.DividaService;
import com.roctiv.debtcontroll.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DividaServiceImpl implements DividaService {

    private static final Logger log = LoggerFactory.getLogger(DividaServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private DividaDAO dividaDAO;

    @Override
    public Divida create(DividaModel dividaModel) {
        User user = this.userDAO.getUserByUsername(dividaModel.getUser().getUsername());

        Divida divida = new Divida();
        divida.setNome(dividaModel.getNome());
        divida.setParcelas(dividaModel.getParcelas());
        divida.setTotal(dividaModel.getTotal());
        divida.setUser(user);

        log.info("Salvando divida: ", dividaModel.getNome());
        return this.dividaDAO.save(divida);

    }

    @Override
    public List<Divida> listByUser(String username) {
        User user = this.userDAO.getUserByUsername(username);

        return this.dividaDAO.listByUser(user);
    }

    @Override
    public Divida listById(Long id) {
        return this.dividaDAO.listById(id);
    }
}
