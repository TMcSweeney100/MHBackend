// src/main/java/com/maynoothmh/backend/config/CorsConfig.java
package com.maynoothmh.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                       
        		.allowedOrigins("http://localhost:5173","https://mh-front-end-wa6q.vercel.app/") 
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowCredentials(true);
    }
}
