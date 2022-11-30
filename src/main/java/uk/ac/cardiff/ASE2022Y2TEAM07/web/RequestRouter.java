package uk.ac.cardiff.ASE2022Y2TEAM07.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RequestRouter implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/employee").setViewName("/EmployeeHomepage");
        registry.addViewController("/login").setViewName("/LoginPage");
        registry.addViewController("/supervisor/onetone").setViewName("/SupervisorOneToOne");
        registry.addViewController("/supervisor").setViewName("/SupervisorPage");
        registry.addViewController("/employee/checkin").setViewName("/EmployeeCheckinPage");
        registry.addViewController("/employee/onetoone").setViewName("/EmployeeOneToOnePage");
        registry.addViewController("/404").setViewName("error/404");

        registry.addViewController("/employee/goals").setViewName("/EmployeePersonalGoalsPage");

    }

}
