package com.example.gustavo.chat.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.example.gustavo.chat.Dtos.userDto;

public class userServiceTest {

  @Test
  public void testFieldNotNull(userDto user) {
    assertNotNull(user);
  }
}
