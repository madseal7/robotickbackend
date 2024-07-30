package com.example.app1;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@EnableJpaRepositories
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("https://robotick.ru") // Разрешенные домены (ваш фронтенд)
                .allowedMethods("GET", "POST") // Разрешенные методы
                .allowedHeaders("Authorization", "Content-Type") // Разрешенные заголовки
                .allowCredentials(true); // Разрешение куки
    }
}
