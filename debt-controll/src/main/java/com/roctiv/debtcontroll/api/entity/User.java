package com.roctiv.debtcontroll.api.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
public class User implements Serializable {
    private static final long serialVersionUID = 523973042860571998L;

    private Long id;
    private String nome;
    private String username;
    private String pass;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "pass",nullable = false)
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Column(name = "nome", nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
