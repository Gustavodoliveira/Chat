package com.example.gustavo.chat.Dtos;

import com.example.gustavo.chat.models.Roles;

public record userDto(String userName, String email, Integer age, String password, Roles role) {

}
