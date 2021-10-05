package com.vti.config.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
