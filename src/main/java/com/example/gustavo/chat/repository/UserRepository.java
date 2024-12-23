package com.example.gustavo.chat.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.gustavo.chat.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

  public User findByEmail(String email);

  @Transactional
  @Query("update User u set u.email = ?1, u.userName = ?2, u.password = ?3, u.age = ?4 where u.email = ?5")
  List<User> updateUser(String email, String userName, String password, Integer agr, String beforeEmail);
}
