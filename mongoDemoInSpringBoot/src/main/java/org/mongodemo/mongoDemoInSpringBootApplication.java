package org.mongodemo;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.mongodemo.config.checkVariables;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableMongock
public class mongoDemoInSpringBootApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(mongoDemoInSpringBootApplication.class, args);
        context.getBean("check variables", checkVariables.class).PriorityProvider();
    }
}
