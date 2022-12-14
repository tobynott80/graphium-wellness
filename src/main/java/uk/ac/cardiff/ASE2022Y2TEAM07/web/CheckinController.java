package uk.ac.cardiff.ASE2022Y2TEAM07.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.CheckinDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.CheckinRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.EmployeeRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.CheckinService;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.forms.CheckinForm;

import java.sql.Date;
import javax.validation.Valid;
import java.time.LocalDate;

@RequestMapping("employee/checkin")
@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
@Controller
public class CheckinController {

    @Autowired
    private final CheckinService checkinService;

    @Autowired
    private final CheckinRepository checkinRepository;

    @Autowired
    private final OneToOneController oneToOneController;

    @Autowired
    private final EmployeeRepository employeeRepository;


    private String getCurrentEmployeeEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
    }

    public Employee getCurrentEmployee() {
        String email = getCurrentEmployeeEmail();
        return employeeRepository.findByEmail(email);
    }
    @Autowired
    public CheckinController(CheckinService checkinService, CheckinRepository checkinRepository, OneToOneController oneToOneController, EmployeeRepository employeeRepository) {
        this.checkinService = checkinService;
        this.checkinRepository = checkinRepository;
        this.oneToOneController = oneToOneController;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("")
    public ModelAndView checkinsForm(Model model) {
        Employee em = this.getCurrentEmployee();
        String employeeName = this.getCurrentEmployee().getName().toLowerCase();
        String employeeNameCapitalized = employeeName.substring(0, 1).toUpperCase() + employeeName.substring(1);
        model.addAttribute("employeeName", employeeNameCapitalized);

        model.addAttribute("employeeName", employeeNameCapitalized);
        model.addAttribute("supervisor", "Carl");
        model.addAttribute("checkinForm", new CheckinForm(em.getEmployeeId(), 5));
        var mv = new ModelAndView("employee/EmployeeCheckinPage", model.asMap());
        return mv;
    }

    @PostMapping("")
    public ModelAndView checkinForm(@Valid CheckinForm checkinForm, BindingResult bindingResult, Model model) {

        // gets date
        Date now = Date.valueOf(LocalDate.now());
        if (bindingResult.hasErrors()){
            model.addAttribute("employeeName", this.getCurrentEmployee().getName());
            model.addAttribute("supervisor", "Carl");
            model.addAttribute("checkinForm",  checkinForm);
            var mv = new ModelAndView("employee/EmployeeCheckinPage", model.asMap());
            return mv;
        }

        Employee em = this.getCurrentEmployee();

        CheckinDto checkinDto = new CheckinDto(null, em.getEmployeeId(), checkinForm.getScore(), now);
        checkinService.save(checkinDto);

        var mv = new ModelAndView("redirect:/employee", model.asMap());
        return mv;
    }

    @GetMapping("/history")
    public ModelAndView checkinHistory(Model model) {
        Employee employee = this.getCurrentEmployee();
        String employeeName = this.getCurrentEmployee().getName().toLowerCase();
        String employeeNameCapitalized = employeeName.substring(0, 1).toUpperCase() + employeeName.substring(1);
        model.addAttribute("employeeName", employeeNameCapitalized);
        model.addAttribute("checkins", checkinRepository.findAllByEmployeeId(employee.getEmployeeId()));
        var mv = new ModelAndView("employee/EmployeeCheckinHistory", model.asMap());
        return mv;
    }

}



