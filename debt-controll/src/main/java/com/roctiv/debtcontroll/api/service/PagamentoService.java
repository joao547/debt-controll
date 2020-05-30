package com.roctiv.debtcontroll.api.service;

import com.roctiv.debtcontroll.api.entity.Pagamento;
import com.roctiv.debtcontroll.api.model.PagamentoModel;

import java.util.Date;
import java.util.List;

public interface PagamentoService {

    Pagamento create(PagamentoModel pagamentoModel);

    List<Pagamento> listByDivida(Long idDivida);

    List<Pagamento> listByUser(Long idUser);

    List<Pagamento> listByUserAndMonth(Long idUser, Integer mes, Integer ano);

    Pagamento listById(Long id);
}
