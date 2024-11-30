package com.example.gustavo.chat.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.gustavo.chat.Dtos.userDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "user")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User {

  @Id
  private String id;
  private String email;
  private String userName;
  private Integer age;
  private String password;
  private Roles role;

  public User(userDto user) {
    this.email = user.email();
    this.age = user.age();
    this.userName = user.userName();
    this.password = user.password();
    this.role = user.role();
  }
}
