package com.roctiv.debtcontroll.api.service;

import com.roctiv.debtcontroll.api.entity.Divida;
import com.roctiv.debtcontroll.api.model.DividaModel;

import java.util.List;

public interface DividaService {

    Divida create(DividaModel dividaModel);

    List<Divida> listByUser(String username);

    Divida listById(Long id);
}
