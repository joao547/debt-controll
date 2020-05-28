package com.roctiv.debtcontroll.api.response;

import com.roctiv.debtcontroll.api.entity.User;

public class UserResponse {

    private Long id;
    private String nome;
    private String username;
    private String pass;

    public UserResponse(User user){
        this.id = user.getId();
        this.nome = user.getNome();
        this.username = user.getUsername();
        this.pass = user.getPass();
    }
    public UserResponse(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
