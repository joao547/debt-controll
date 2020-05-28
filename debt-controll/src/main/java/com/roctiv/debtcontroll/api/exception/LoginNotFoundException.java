package com.roctiv.debtcontroll.api.exception;

public class LoginNotFoundException extends Exception {
    public LoginNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
