package com.example.gustavo.chat.Exception;

public class EmailExistException extends RuntimeException {
  public EmailExistException(String msg) {
    super(msg);
  }
}
