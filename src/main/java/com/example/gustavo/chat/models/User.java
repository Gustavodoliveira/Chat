package com.example.gustavo.chat.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
}
