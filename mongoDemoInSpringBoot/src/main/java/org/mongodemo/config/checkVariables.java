package org.mongodemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration(value = "check variables")
@PropertySource("classpath:application-dev.properties")
@Slf4j
public class checkVariables {

    @Value("${spring.data.mongodb.database}") String database;
    @Value("${spring.data.mongodb.username}") String username;
    @Value("${spring.data.mongodb.password}") String password;

    @Autowired
    public void PriorityProvider() {
        log.info("database: {}", database);
        log.info("username: {}", username);
        log.info("password: {}", password);
    }
}
