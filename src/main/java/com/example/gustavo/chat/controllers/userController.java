package com.example.gustavo.chat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gustavo.chat.Dtos.userDto;
import com.example.gustavo.chat.Service.userService;
import com.example.gustavo.chat.models.User;
import com.example.gustavo.chat.repository.userRepository;

@RestController
@RequestMapping("/user")
public class userController {

  @Autowired
  private userService userService;

  @Autowired
  private userRepository userRepository;

  @PostMapping("/register")
  public ResponseEntity userRegister(@RequestBody @Validated userDto user) {

    try {
      User newUser = new User(user);
      userService.verifyUserFields(newUser);
      userRepository.save(newUser);
      return ResponseEntity.ok().body("success register");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
