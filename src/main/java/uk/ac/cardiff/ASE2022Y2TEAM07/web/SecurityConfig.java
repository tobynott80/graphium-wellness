package uk.ac.cardiff.ASE2022Y2TEAM07.web;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

//adapted from: https://stackoverflow.com/questions/49387988/authentication-of-users-from-two-database-tables-in-spring-security

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//
//    @Bean
//    @Order(1)
//    public SecurityFilterChain h2FilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests().requestMatchers("/h2-console/**").permitAll();
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin();
        return http.build();
    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//
//}



    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        // TODO: Low Priority: Replace NoOpPasswordEncoder with BCryptPasswordEncoder
        // This assumes passwords are in plain text - THEY WON'T BE IN PRODUCTION!! - This should definitely be changed to BCrypt
        authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return authProvider;
    }

}