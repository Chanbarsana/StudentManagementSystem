package com.example.StudentMangementSystem.Student_Mangement_System_Backend.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // your frontend's URL
                .allowedMethods("GET", "POST", "PUT", "DELETE") //HTTP REQUEST METHOD
                .allowedHeaders("*");
    }
}
