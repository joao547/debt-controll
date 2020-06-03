package com.roctiv.debtcontroll.api.security.jwt;

public class SecurityConfig {
    public static final String SECRET = "ApiDeGerenciamentoDeDivida";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_IN_URL = "/auth";
    static final long EXPIRATION_TIME = 86400000L;
}
