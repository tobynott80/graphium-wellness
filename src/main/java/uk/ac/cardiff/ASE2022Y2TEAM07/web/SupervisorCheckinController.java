package uk.ac.cardiff.ASE2022Y2TEAM07.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.EmployeeDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.CheckinRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.EmployeeRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.EmployeeService;

import java.util.List;
import java.util.Optional;


@Controller
@PreAuthorize("hasRole('ROLE_SUPERVISOR')")
@RequestMapping("/supervisor")
public class SupervisorCheckinController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CheckinRepository checkinRepository;

    private List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("")
    public ModelAndView getAllEmployees(Model model){
        List<Employee> AllEmployees = getEmployees();

        for (Employee e : AllEmployees){
            String SingleEmployee = e.getName();
            model.addAttribute("EmployeeName", SingleEmployee);
        }

        var mv = new ModelAndView("supervisor/SupervisorPage", model.asMap());
        return mv;
    }

    @GetMapping("/employee/{furl}")
    public ModelAndView getEmployeeCheckinHistoryPage(@PathVariable("furl") Optional<Integer> furl, Model model) {
        Employee employee = employeeRepository.findByEmployeeId(furl.get());
        model.addAttribute("EmployeeName", employee.getName());
        model.addAttribute("checkins", checkinRepository.findAllByEmployeeId(furl.get()).stream().toList());
        var mv = new ModelAndView("supervisor/EmployeeCheckinHistory", model.asMap());
        return mv;
    }

}
