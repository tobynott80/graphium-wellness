package uk.ac.cardiff.ASE2022Y2TEAM07.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/supervisor/employee")
public class SupervisorCheckinController {
    @GetMapping("{furl}")
    public ModelAndView getEmployeeCheckinHistoryPage() {
        var mv = new ModelAndView("supervisor/EmployeeCheckinHistory");
        return mv;
    }

}
