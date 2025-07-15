package com.example.securityApp.security.App.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCode {
    @Bean
    ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
