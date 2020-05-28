package com.roctiv.debtcontroll.api.controller;

import com.roctiv.debtcontroll.api.entity.User;
import com.roctiv.debtcontroll.api.exception.LoginNotFoundException;
import com.roctiv.debtcontroll.api.model.LoginModel;
import com.roctiv.debtcontroll.api.model.UserModel;
import com.roctiv.debtcontroll.api.response.UserResponse;
import com.roctiv.debtcontroll.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> insertUser(@RequestBody UserModel userModel) throws NoSuchAlgorithmException {
        User user = this.formatUser(userModel);

        UserResponse response = new UserResponse(this.userService.createUser(user));

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> listUser() throws NoSuchAlgorithmException {
        List<UserResponse> response = this.getUsers(this.userService.listAll());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/id")
    public ResponseEntity<UserResponse> getUser(@RequestHeader Long id) throws NoSuchAlgorithmException {
       UserResponse response = new UserResponse(this.userService.getUser(id));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginModel login) throws NoSuchAlgorithmException {

        UserResponse response = null;
        try {
            response = new UserResponse(this.userService.login(login.getUsername(),login.getPass()));
        } catch (LoginNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok(response);
    }

    private User formatUser(UserModel userModel){
        User user = new User();
        user.setNome(userModel.getNome());
        user.setUsername(userModel.getUsername());
        user.setPass(userModel.getPass());
        return user;
    }

    private List<UserResponse> getUsers(List<User> users){
        List<UserResponse> userResponses = new ArrayList<>();
        for(User user : users){
            userResponses.add(new UserResponse(user));
        }
        return userResponses;
    }
}
