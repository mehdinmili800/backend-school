package com.mehdi.project_school.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://school-angular.s3-website.eu-north-1.amazonaws.com")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*") // Specify allowed headers
                .allowCredentials(true);
    }
}
