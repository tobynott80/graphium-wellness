package uk.ac.cardiff.ASE2022Y2TEAM07.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RequestRouter implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/employee").setViewName("employee/EmployeeHomepage");
//        registry.addViewController("/login").setViewName("/LoginPage");
        registry.addViewController("/supervisor/onetone").setViewName("supervisor/SupervisorOneToOne");
        registry.addViewController("/supervisor").setViewName("supervisor/SupervisorPage");
        registry.addViewController("/404").setViewName("error/404");
        registry.addViewController("/employee/goals").setViewName("employee/EmployeePersonalGoalsPage");

    }

}
