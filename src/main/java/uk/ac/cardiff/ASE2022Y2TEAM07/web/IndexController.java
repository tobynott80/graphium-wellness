package uk.ac.cardiff.ASE2022Y2TEAM07.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.EmployeeRepository;

@Controller
@RequestMapping("/")
public class IndexController {

    private final EmployeeRepository employeeRepository;

    public IndexController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    private String getUserRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserRole = authentication.getAuthorities().toString();
        return currentUserRole;
    }

    @GetMapping
    public String redirectUser() {
        if (getUserRole().equals("[ROLE_SUPERVISOR]")) {
            return "redirect:/supervisor";
        } else if (getUserRole().equals("[ROLE_EMPLOYEE]")) {
            return "redirect:/employee";
        } else {
            return "redirect:/login";
        }
    }

    private String getCurrentEmployeeEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
    }

    public Employee getCurrentEmployee() {
        String email = getCurrentEmployeeEmail();
        return employeeRepository.findByEmail(email);
    }

    @GetMapping("/employee")
    public ModelAndView getEmployeeHomepage(Model model) {
        String employeeName = this.getCurrentEmployee().getName().toLowerCase();
        String employeeNameCapitalized = employeeName.substring(0, 1).toUpperCase() + employeeName.substring(1);
        model.addAttribute("employeeName", employeeNameCapitalized);
        var mv = new ModelAndView("employee/EmployeeHomepage.html", model.asMap());
        return mv;
    }

}
