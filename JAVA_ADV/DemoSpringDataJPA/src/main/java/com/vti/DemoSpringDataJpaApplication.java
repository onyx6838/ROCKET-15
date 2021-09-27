package com.vti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan("com.vti")
public class DemoSpringDataJpaApplication {

    private static ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringDataJpaApplication.class, args);
    }

    public static <T> T getBean(Class<T> bean) {
        return context.getBean(bean);
    }

}
