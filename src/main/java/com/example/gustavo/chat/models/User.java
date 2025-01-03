package com.example.gustavo.chat.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.gustavo.chat.Dtos.users.userDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(length = 60, nullable = false, unique = true)
  private String email;

  @Column(length = 60, nullable = false, unique = true)
  private String userName;

  @Column(length = 60, nullable = false)
  private Integer age;

  @Column(length = 60, nullable = false)
  private String password;

  @Column()
  private Roles role;

  public User(userDto user) {
    this.email = user.email();
    this.age = user.age();
    this.userName = user.userName();
    this.password = user.password();
    this.role = user.role();
  }

  public User(User data, String encryptedPassword) {
    this.email = data.email;
    this.userName = data.userName;
    this.age = data.age;
    this.role = data.role;
    this.password = encryptedPassword;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if (this.role == Roles.ADMIN)
      return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
    else
      return List.of(new SimpleGrantedAuthority("ROLE_USER"));
  }

  @Override
  public String getUsername() {
    return this.userName;
  }
}
