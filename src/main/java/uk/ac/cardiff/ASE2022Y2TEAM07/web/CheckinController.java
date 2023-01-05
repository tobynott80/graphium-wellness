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
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.SupervisorRepository;
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
    private final EmployeeRepository employeeRepository;

    @Autowired
    private final SupervisorRepository supervisorRepository;


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
    public CheckinController(CheckinService checkinService, CheckinRepository checkinRepository, EmployeeRepository employeeRepository, SupervisorRepository supervisorRepository) {
        this.checkinService = checkinService;
        this.checkinRepository = checkinRepository;
        this.employeeRepository = employeeRepository;
        this.supervisorRepository = supervisorRepository;
    }

    @GetMapping("")
    public ModelAndView checkinsForm(Model model) {
        Employee em = this.getCurrentEmployee();
        String employeeName = this.getCurrentEmployee().getName().toLowerCase();
        String employeeNameCapitalized = employeeName.substring(0, 1).toUpperCase() + employeeName.substring(1);
        String supervisorName = supervisorRepository.findBySupervisorId(em.getSupervisorId()).getName().toLowerCase();
        String supervisorNameCapitalized = supervisorName.substring(0, 1).toUpperCase() + supervisorName.substring(1);
        model.addAttribute("employeeName", employeeNameCapitalized);
        model.addAttribute("employeeName", employeeNameCapitalized);
        model.addAttribute("supervisor", supervisorNameCapitalized);
        model.addAttribute("checkinForm", new CheckinForm(em.getEmployeeId(), 5, Boolean.FALSE));
        var mv = new ModelAndView("employee/EmployeeCheckinPage", model.asMap());
        return mv;
    }

    @PostMapping("")
    public ModelAndView checkinForm(@Valid CheckinForm checkinForm, BindingResult bindingResult, Model model) {
        // gets date
        Date now = Date.valueOf(LocalDate.now());
        if (bindingResult.hasErrors()){
            model.addAttribute("employeeName", this.getCurrentEmployee().getName());
//            model.addAttribute("supervisor", "Carl");
            model.addAttribute("checkinForm",  checkinForm);
            var mv = new ModelAndView("employee/EmployeeCheckinPage", model.asMap());
            return mv;
        }

        Employee em = this.getCurrentEmployee();

        CheckinDto checkinDto = new CheckinDto(null, em.getEmployeeId(), checkinForm.getScore(), now);
        checkinService.save(checkinDto);
        if(checkinForm.getWantsMeeting()){
            return new ModelAndView("redirect:/employee/onetoone", model.asMap());
        }
        return new ModelAndView("redirect:/employee", model.asMap());

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

