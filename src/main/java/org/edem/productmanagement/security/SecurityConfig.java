package org.edem.productmanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        httpSecurity
                .authorizeHttpRequests(
                        auth -> auth.requestMatchers("/error").permitAll()
//                                .requestMatchers("/swagger-ui.html","/swagger.ui/**", "/v1/api-docs/**").permitAll()
//                                .requestMatchers("/api/v1/product/**").permitAll()
//                                .requestMatchers("api/v1/category/**").permitAll()
//                                .requestMatchers("/api/v1/auth/**").permitAll()
                                .anyRequest().permitAll());

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

