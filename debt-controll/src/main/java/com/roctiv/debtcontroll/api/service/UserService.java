package com.roctiv.debtcontroll.api.service;

import com.roctiv.debtcontroll.api.entity.User;
import com.roctiv.debtcontroll.api.exception.LoginNotFoundException;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> listAll();

    User getUser(Long id);

    User login(String username, String pass) throws LoginNotFoundException;
}
