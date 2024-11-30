package com.example.gustavo.chat.Service;

import org.springframework.stereotype.Service;

import com.example.gustavo.chat.Dtos.userDto;
import com.example.gustavo.chat.Exception.FieldNullException;
import com.example.gustavo.chat.models.User;

@Service
public class userService {

  public boolean verifyUserFields(User newUser) {
    if (newUser.getAge() == null)
      throw new FieldNullException("age is null");

    if (newUser.getEmail() == null)
      throw new FieldNullException("email is null");

    if (newUser.getUserName() == null)
      throw new FieldNullException("user name is null");

    if (newUser.getPassword() == null)
      throw new FieldNullException("password is null");

    return true;

  }
}
