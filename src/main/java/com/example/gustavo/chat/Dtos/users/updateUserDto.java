package com.example.gustavo.chat.Dtos.users;

import com.example.gustavo.chat.models.Roles;

public record updateUserDto(String userName, String email, Integer age, String password, Roles roles) {

}
