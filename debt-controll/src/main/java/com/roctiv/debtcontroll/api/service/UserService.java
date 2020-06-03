package com.roctiv.debtcontroll.api.service;

import com.roctiv.debtcontroll.api.entity.User;
import com.roctiv.debtcontroll.api.exception.LoginNotFoundException;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Map;

public interface UserService {

    User createUser(User user);

    List<User> listAll();

    User getUser(Long id);

    User login(String username, String pass) throws LoginNotFoundException;

    User getUser(Map<String,String> headers);
}
