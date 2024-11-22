package com.example.gustavo.chat.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.gustavo.chat.models.User;

public interface userRepository extends ReactiveMongoRepository<User, String> {

}
