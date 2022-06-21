package com.example.demoearthquake.security_config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/users/signin").permitAll()//
                .antMatchers("/users/signup").permitAll()//
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated();
        http.headers().frameOptions().disable();
        http.httpBasic();

        return http.build();
    }
}
