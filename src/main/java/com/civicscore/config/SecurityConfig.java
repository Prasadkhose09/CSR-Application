package com.civicscore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        // PUBLIC
                        .requestMatchers("/citizens/**").permitAll()

                        // ADMIN ONLY
                        .requestMatchers("/violations/**").hasRole("ADMIN")
                        .requestMatchers("/appeals/**").hasRole("ADMIN")

                        // CITIZEN & ADMIN
                        .requestMatchers("/score-history/**").hasAnyRole("CITIZEN", "ADMIN")
                        .requestMatchers("/incentives/**").hasAnyRole("CITIZEN", "ADMIN")

                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
