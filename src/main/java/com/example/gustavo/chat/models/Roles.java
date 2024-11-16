package com.example.gustavo.chat.models;

public enum Roles {
  ADMIN("admin"),
  USER("user");

  private String role;

  Roles(String Role) {
    this.role = role;
  }
}
