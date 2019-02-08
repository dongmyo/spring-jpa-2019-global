package com.nhnent.edu.spring_jpa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// TODO : #7 web config
@Configuration
@EnableWebMvc
@ComponentScan("com.nhnent.edu.spring_jpa.controller")
public class WebConfig implements WebMvcConfigurer {
}
