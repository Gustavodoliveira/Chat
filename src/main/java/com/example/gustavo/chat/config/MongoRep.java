package com.example.gustavo.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.acme..repositories")
public class MongoRep extends AbstractMongoClientConfiguration {

  @Override
  protected String getDatabaseName() {
    return "chat";
  }

  protected String getMappingBasePackage() {
    return "com.acme..repositories";
  }

}
