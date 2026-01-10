package com.example.demo.onfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();

        // ✅ FIXED: List explicit origins instead of "*"
        corsConfig.addAllowedOrigin("http://localhost:4200");  // Angular dev
        corsConfig.addAllowedOrigin("http://localhost:3000");  // Alternative dev
        // corsConfig.addAllowedOrigin("https://yourdomain.com"); // Production
        
        // ✅ REMOVE the wildcard "*"
        // corsConfig.addAllowedOrigin("*"); // ❌ DELETE THIS LINE

        // Allow methods
        corsConfig.addAllowedMethod("GET");
        corsConfig.addAllowedMethod("POST");
        corsConfig.addAllowedMethod("PUT");
        corsConfig.addAllowedMethod("DELETE");
        corsConfig.addAllowedMethod("OPTIONS");
        // OR use wildcard for methods (this is safe):
        // corsConfig.addAllowedMethod("*");

        // Allow headers
        corsConfig.addAllowedHeader("*");

        // ✅ Now safe to use credentials with explicit origins
        corsConfig.setAllowCredentials(true);

        // Allow response headers
        corsConfig.addExposedHeader("Authorization");
        corsConfig.addExposedHeader("Content-Type");
        corsConfig.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }
}