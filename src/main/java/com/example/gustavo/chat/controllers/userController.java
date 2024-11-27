package com.example.gustavo.chat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gustavo.chat.Dtos.userDto;
import com.example.gustavo.chat.Service.userService;

@RestController
@RequestMapping("/user")
public class userController {

  @Autowired
  private userService userService;

  @PostMapping()
  public ResponseEntity userRegister(@RequestBody userDto user) {
    boolean userField = userService.verifyUserFields(user);

    return ResponseEntity.ok().build();

  }
}
