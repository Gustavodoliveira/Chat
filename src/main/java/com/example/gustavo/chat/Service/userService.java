package com.example.gustavo.chat.Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gustavo.chat.Dtos.users.updateUserDto;
import com.example.gustavo.chat.Exception.EmailExistException;
import com.example.gustavo.chat.Exception.FieldNullException;
import com.example.gustavo.chat.infra.FilterSecurity;
import com.example.gustavo.chat.models.User;
import com.example.gustavo.chat.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class userService {

  @Autowired
  TokenService tokenService;

  @Autowired
  FilterSecurity filterSecurity;

  @Autowired
  HttpServletRequest req;

  @Autowired
  private UserRepository userRepository;

  public String updateUser(updateUserDto data) throws Exception {
    User user = this.findUserByToken();
    User userUpdate = new User();

    userUpdate.setRole(user.getRole());

    if (data.email() == null)
      userUpdate.setEmail(user.getEmail());
    else
      userUpdate.setEmail(data.email());

    if (data.userName() == null)
      userUpdate.setUserName(user.getUsername());
    else
      userUpdate.setUserName(data.userName());

    if (data.password() == null)
      userUpdate.setPassword(user.getPassword());
    else
      userUpdate.setPassword(data.password());

    try {
      return "update success";
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }

  }

  public String deleteUser() throws SQLException {
    User user = this.findUserByToken();
    try {
      userRepository.deleteById(user.getId());
      return "User delete success";
    } catch (Exception e) {
      throw new SQLException(e.getMessage());
    }
  }

  public List<User> findAllUsers() throws SQLException {
    try {
      return userRepository.findAll();
    } catch (Exception e) {
      throw new SQLException(e.getMessage());
    }
  }

  public User findUser(User user) {
    return userRepository.findByEmail(user.getEmail());
  }

  public User saveUser(User user) {
    User usr = this.findUser(user);
    if (usr != null)
      throw new EmailExistException("Email exist");

    String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
    User newUsrEncryptedPassword = new User(user, encryptedPassword);
    return userRepository.save(newUsrEncryptedPassword);
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

  public User findUserByToken() throws SQLException {
    try {
      String token = this.filterSecurity.recoverToken(req);
      String email = tokenService.validateToken(token);
      User user = userRepository.findByEmail(email);
      return user;
    } catch (Exception e) {
      throw new SQLException(e.getMessage());
    }

  }
}
