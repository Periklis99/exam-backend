package com.example.examproject.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOriginPatterns(List.of("*"));
//        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedHeader("Authorization");
        config.addAllowedMethod("*");
        config.setMaxAge(3600L); //1 hour
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
