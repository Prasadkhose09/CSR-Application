package com.civicscore.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http
                .csrf(csrf ->csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/citizens/**").permitAll()

                        .requestMatchers("/violations/**").hasRole("ADMIN")
                        .requestMatchers("/appeals/**").hasRole("ADMIN")


                        .requestMatchers("/score-history/**").hasAnyRole("CITIZEN", "ADMIN")
                        .requestMatchers("/incentives/**").hasAnyRole("CITIZEN", "ADMIN")
                        .anyRequest().authenticated()
                   )

                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService users() {

        UserDetails admin = User.withUsername("admin")
                .password("{noop}admin123")
                .roles("ADMIN")
                .build();

        UserDetails citizen = User.withUsername("citizen")
                .password("{noop}citizen123")
                .roles("CITIZEN")
                .build();

        return new InMemoryUserDetailsManager(admin, citizen);
    }

}
