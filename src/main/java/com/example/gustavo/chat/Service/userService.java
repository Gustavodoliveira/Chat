package com.example.gustavo.chat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gustavo.chat.Dtos.userDto;
import com.example.gustavo.chat.Exception.FieldNullException;
import com.example.gustavo.chat.models.User;
import com.example.gustavo.chat.repository.userRepository;

@Service
public class userService {

  private userRepository userRepository;

  public boolean verifyUserFields(userDto user) {
    if (user.age() == null)
      throw new FieldNullException("age is null");
    return true;

  }
}
