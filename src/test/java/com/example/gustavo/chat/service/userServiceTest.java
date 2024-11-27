package com.example.gustavo.chat.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.gustavo.chat.Dtos.userDto;
import com.example.gustavo.chat.Service.userService;
import com.example.gustavo.chat.models.User;

public class userServiceTest {
  @Autowired
  private userService userService;

  @Test
  public void testFieldNotNull() throws Exception {
    User user = new User();
    assertNotNull(userService.verifyUserFields(user));
  }
}
