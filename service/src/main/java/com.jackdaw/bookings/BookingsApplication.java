package com.jackdaw.bookings;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@SpringBootApplication
public class BookingsApplication {
    public static void main(final String[] args) {
        SpringApplication.run(BookingsApplication.class, args);
    }

    /**
     * Basic CORS filter.
     *
     * @param env The current Spring environment
     * @return new {@link CorsFilter} Bean
     */
    @Bean
    public CorsFilter corsFilter(final Environment env) {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfig = new CorsConfiguration();

        corsConfig.setAllowCredentials(env.getProperty("cors.getAllowCredentials", Boolean.class, null));
        corsConfig.setAllowedHeaders(env.getProperty("cors.allowedHeaders", List.class, null));
        corsConfig.setAllowedMethods(env.getProperty("cors.allowedMethods", List.class, null));
        corsConfig.setAllowedOrigins(env.getProperty("cors.allowedOrigins", List.class, null));
        corsConfig.setExposedHeaders(env.getProperty("cors.exposedHeaders", List.class, null));
        corsConfig.setMaxAge(env.getProperty("cors.maxAge", Long.class, null));

        source.registerCorsConfiguration("/**", corsConfig);
        return new CorsFilter(source);
    }

    @Bean
    @Primary
    public ObjectMapper om() {
        return new ObjectMapper();
    }

}
