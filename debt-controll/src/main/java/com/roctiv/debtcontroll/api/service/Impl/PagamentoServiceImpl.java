package com.roctiv.debtcontroll.api.service.Impl;

import com.roctiv.debtcontroll.api.dao.DividaDAO;
import com.roctiv.debtcontroll.api.dao.PagamentoDAO;
import com.roctiv.debtcontroll.api.entity.Divida;
import com.roctiv.debtcontroll.api.entity.Pagamento;
import com.roctiv.debtcontroll.api.enums.StatusPagamento;
import com.roctiv.debtcontroll.api.model.PagamentoModel;
import com.roctiv.debtcontroll.api.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private DividaDAO dividaDAO;

    @Autowired
    private PagamentoDAO pagamentoDAO;

    @Override
    public Pagamento create(PagamentoModel pagamentoModel) {
        Divida divida = this.dividaDAO.listById(pagamentoModel.getDivida().getId());
        divida.getUser();
        Pagamento pagamento = new Pagamento();
        pagamento.setDivida(divida);
        pagamento.setDataDaParcela(pagamentoModel.getDataDaParcela());
        pagamento.setStatus(StatusPagamento.A_PAGAR);
        pagamento.setValorDaParcela(pagamentoModel.getValorDaParcela());
        return this.pagamentoDAO.save(pagamento);
    }

    @Override
    public List<Pagamento> listByDivida(Long idDivida) {
        Divida divida = this.dividaDAO.listById(idDivida);
        return this.pagamentoDAO.listByDivida(divida);
    }

    @Override
    public Pagamento listById(Long id) {
        return null;
    }
}
