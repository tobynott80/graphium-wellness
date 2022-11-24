package uk.ac.cardiff.ASE2022Y2TEAM07.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RequestRouter implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("login").setViewName("/LoginPage");
        registry.addViewController("/employee/checkin").setViewName("/EmployeeCheckinPage");
        registry.addViewController("/404").setViewName("error/404");
    }

}