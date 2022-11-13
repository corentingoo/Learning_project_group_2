package be.ifosup.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages ={"users.create"} )
public class LearningApplication {

    public static void main(String[] args) {

        SpringApplication.run(LearningApplication.class, args);
    }

}
