// src/main/java/com/maynoothmh/backend/config/CorsConfig.java
package com.maynoothmh.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOriginPatterns(
            "http://localhost:5173",
            "https://*.vercel.app"   // covers preview + production
        )
        .allowedMethods("GET","POST","PUT","DELETE","PATCH","OPTIONS")
        .allowedHeaders("*")
        .exposedHeaders("*")
        .allowCredentials(false)    // set true ONLY if you use cookies
        .maxAge(3600);
  }
}
