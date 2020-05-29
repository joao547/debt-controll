package com.roctiv.debtcontroll.api.response;

import com.roctiv.debtcontroll.api.entity.Pagamento;
import com.roctiv.debtcontroll.api.enums.StatusPagamento;

import java.util.Date;

public class PagamentoResponse {

    private Long id;
    private Date dataDaParcela;
    private double valorDaParcela;
    private StatusPagamento status;

    public PagamentoResponse(Pagamento pagamento){
        this.id = pagamento.getId();
        this.dataDaParcela = pagamento.getDataDaParcela();
        this.valorDaParcela = pagamento.getValorDaParcela();
        this.status = pagamento.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataDaParcela() {
        return dataDaParcela;
    }

    public void setDataDaParcela(Date dataDaParcela) {
        this.dataDaParcela = dataDaParcela;
    }

    public double getValorDaParcela() {
        return valorDaParcela;
    }

    public void setValorDaParcela(double valorDaParcela) {
        this.valorDaParcela = valorDaParcela;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }
}
