package com.roctiv.debtcontroll.api.model;

import com.roctiv.debtcontroll.api.entity.Divida;
import com.roctiv.debtcontroll.api.enums.StatusPagamento;

import java.util.Date;

public class PagamentoModel {

    private Long id;
    private Date dataDaParcela;
    private double valorDaParcela;
    private Divida divida;

    public PagamentoModel(){}

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

    public Divida getDivida() {
        return divida;
    }

    public void setDivida(Divida divida) {
        this.divida = divida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
