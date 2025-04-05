package com.graphqljava.tutorial.bookDetails.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Cấu hình cho phép CORS từ localhost:3000 (Frontend React)
        registry.addMapping("/**")  // Áp dụng cho tất cả các endpoint của ứng dụng
                .allowedOrigins("http://localhost:3000")  // Chỉ cho phép yêu cầu từ localhost:3000
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Các phương thức HTTP được phép
                .allowedHeaders("*");  // Cho phép tất cả các headers
    }
}
