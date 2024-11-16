package com.example.gustavo.chat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

  @Value("${api.secret.security}")
  private String secret;

}
