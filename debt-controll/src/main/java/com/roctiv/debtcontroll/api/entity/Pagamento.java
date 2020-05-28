package com.roctiv.debtcontroll.api.entity;

import com.roctiv.debtcontroll.api.enums.StatusPagamento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pagamento")
public class Pagamento implements Serializable {

    private static final long serialVersionUID = -4284391608337259291L;

    private Long id;
    private Date dataDaParcela;
    private double valorDaParcela;
    private Divida divida;
    private StatusPagamento status;

    public Pagamento(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "valor_da_parcela",nullable = false)
    public double getValorDaParcela() {
        return valorDaParcela;
    }

    public void setValorDaParcela(double valorDaParcela) {
        this.valorDaParcela = valorDaParcela;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Divida getDivida() {
        return divida;
    }

    public void setDivida(Divida divida) {
        this.divida = divida;
    }

    @Column(name = "data_da_parcela", nullable = false)
    public Date getDataDaParcela() {
        return dataDaParcela;
    }

    public void setDataDaParcela(Date dataDaParcela) {
        this.dataDaParcela = dataDaParcela;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }
}
