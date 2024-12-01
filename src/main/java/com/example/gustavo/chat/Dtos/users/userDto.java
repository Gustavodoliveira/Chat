package com.example.gustavo.chat.Dtos.users;

import com.example.gustavo.chat.models.Roles;

import lombok.Setter;

public record userDto(String userName, String email, Integer age, String password, Roles role) {

}
