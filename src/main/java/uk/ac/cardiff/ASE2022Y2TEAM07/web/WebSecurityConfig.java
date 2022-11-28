package uk.ac.cardiff.ASE2022Y2TEAM07.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

//TODO: Low Priority: Replace deprecated WebSecuityConfigurerAdapter with SecurityFilterChain Bean to configure HttpSecurity and a WebSecurityCustomizer Bean to configure WebSecurity

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from User where username = ?")
                .authoritiesByUsernameQuery("select username, roles from user_roles where username = ?");

    }


}