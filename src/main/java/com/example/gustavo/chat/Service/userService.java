package com.example.gustavo.chat.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gustavo.chat.Exception.EmailExistException;
import com.example.gustavo.chat.Exception.FieldNullException;
import com.example.gustavo.chat.models.User;
import com.example.gustavo.chat.repository.userRepository;
import com.mongodb.MongoException;

@Service
public class userService {

  @Autowired
  private userRepository userRepository;

  public List<User> findAllUsers() {
    try {
      return userRepository.findAll();
    } catch (Exception e) {
      throw new MongoException(e.getMessage());
    }

  }

  public User findUser(User user) {
    return userRepository.findByEmail(user.getEmail());
  }

  public User saveUser(User user) {
    User usr = this.findUser(user);
    if (usr != null)
      throw new EmailExistException("Email exist");
    return userRepository.save(user);
  }

  public boolean verifyUserFields(User newUser) {
    if (newUser.getAge() == null)
      throw new FieldNullException("age is null");

    if (newUser.getEmail() == null)
      throw new FieldNullException("email is null");

    if (newUser.getUsername() == null)
      throw new FieldNullException("user name is null");

    if (newUser.getPassword() == null)
      throw new FieldNullException("password is null");

    return true;

  }
}
