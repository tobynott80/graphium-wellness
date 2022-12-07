package uk.ac.cardiff.ASE2022Y2TEAM07.web;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.NoteDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.EmployeeRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.EmployeeService;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.OneToOneService;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.forms.OneToOneForm;

@Controller
@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
@RequestMapping("employee/onetoone")
public class OneToOneController {
    private final OneToOneService oneToOneService;

    private final EmployeeRepository employeeRepository;

    public OneToOneController(OneToOneService oneToOneService, EmployeeRepository employeeRepository) {
        this.oneToOneService = oneToOneService;
        this.employeeRepository = employeeRepository;
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
    @GetMapping("")
    public ModelAndView getOneToOneForm (Model model) {
        model.addAttribute("OneToOneForm", new OneToOneForm());
        var mv = new ModelAndView("employee/EmployeeOneToOnePage", model.asMap());
        return mv;
    }

    @PostMapping("")
    public ModelAndView postOneToOneForm (Model model, OneToOneForm oneToOneForm) {
         Employee employee = getCurrentEmployee();

        OneToOneDto oneToOneDto = new OneToOneDto(1, employee.getEmployeeId(), employee.getSupervisorId(), oneToOneForm.getDate());
        NoteDto noteDto = new NoteDto(1, 1, oneToOneForm.getNotes());
        oneToOneService.save(oneToOneDto, noteDto);
        var mv = new ModelAndView("employee/EmployeeHomepage.html");
        return mv;
    }
}
