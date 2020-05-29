package com.roctiv.debtcontroll.api.service;

import com.roctiv.debtcontroll.api.entity.Pagamento;
import com.roctiv.debtcontroll.api.model.PagamentoModel;

import java.util.List;

public interface PagamentoService {

    Pagamento create(PagamentoModel pagamentoModel);

    List<Pagamento> listByDivida(Long idDivida);

    Pagamento listById(Long id);
}
