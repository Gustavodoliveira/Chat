package com.example.gustavo.chat.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.gustavo.chat.models.User;

@Repository
public interface userRepository extends MongoRepository<User, String> {

  public User findByEmail(String email);

}
