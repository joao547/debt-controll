package com.roctiv.debtcontroll.api.response;

import com.roctiv.debtcontroll.api.entity.Divida;
import com.roctiv.debtcontroll.api.entity.User;

public class DividaResponse {

    private Long id;
    private String nome;
    private int parcelas;
    private double total;

    public DividaResponse(Divida divida){
        this.id = divida.getId();
        this.nome = divida.getNome();
        this.parcelas = divida.getParcelas();
        this.total = divida.getTotal();
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
