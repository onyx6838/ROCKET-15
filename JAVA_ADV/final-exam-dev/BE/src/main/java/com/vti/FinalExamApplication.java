package com.vti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.vti")
public class FinalExamApplication {
    public static void main(String[] args) {
        SpringApplication.run(FinalExamApplication.class, args);
    }
}
