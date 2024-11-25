package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration


public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Allow CORS for all endpoints
                        .allowedOrigins("http://localhost:63342") // Replace with your frontend's URL
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // HTTP methods to allow
                        .allowedHeaders("*") // Allow all headers
                        .allowCredentials(true); // Allow sending cookies/credentials
            }
        };
    }

}
