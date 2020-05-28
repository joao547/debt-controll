package com.roctiv.debtcontroll.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

    private static final Logger log = LoggerFactory.getLogger(PasswordUtils.class);
    private static BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
    public PasswordUtils(){

    }

    public static String gerarByCrypt(String senha){
        if (senha == null){
            return senha;
        }
        log.info("Gerando hash de: "+senha+", com o BCrypt.");
        return bCryptEncoder.encode(senha);
    }

    public static boolean isValid(String senhaNormal, String senhaEncode){
        return bCryptEncoder.matches(senhaNormal, senhaEncode);
    }

    public static void main(String[] args) {
        String senha = gerarByCrypt("86521248");
        System.out.println(senha);
    }
}
