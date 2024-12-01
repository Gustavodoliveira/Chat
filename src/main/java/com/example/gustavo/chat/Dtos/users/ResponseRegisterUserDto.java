package com.example.gustavo.chat.Dtos.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ResponseRegisterUserDto {
  private String msg;
  private String token;
}
