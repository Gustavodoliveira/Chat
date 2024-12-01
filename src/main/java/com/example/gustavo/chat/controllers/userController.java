package com.example.gustavo.chat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gustavo.chat.Dtos.users.ResponseRegisterUserDto;
import com.example.gustavo.chat.Dtos.users.userDto;
import com.example.gustavo.chat.Service.TokenService;
import com.example.gustavo.chat.Service.userService;
import com.example.gustavo.chat.models.User;

@RestController
@RequestMapping("/user")
public class userController {

  @Autowired
  private userService userService;

  @Autowired
  private TokenService tokenService;

  @PostMapping("/register")
  public ResponseEntity userRegister(@RequestBody @Validated userDto user) {

    try {
      User newUser = new User(user);
      userService.saveUser(newUser);
      String token = tokenService.generateToken(newUser);
      ResponseRegisterUserDto responseRegisterUserDto = new ResponseRegisterUserDto("success register", token);
      return ResponseEntity.ok().body(responseRegisterUserDto);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping
  public ResponseEntity findAllUsers() {
    try {
      List<User> users = userService.findAllUsers();
      return ResponseEntity.ok().body(users);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e);
    }

  }
}
