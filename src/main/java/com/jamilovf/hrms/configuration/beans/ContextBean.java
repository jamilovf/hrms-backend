package com.jamilovf.hrms.configuration.beans;

import com.jamilovf.hrms.configuration.context.SpringApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextBean {
    @Bean
    public SpringApplicationContext springApplicationContext() {
        return new SpringApplicationContext();
    }
}
