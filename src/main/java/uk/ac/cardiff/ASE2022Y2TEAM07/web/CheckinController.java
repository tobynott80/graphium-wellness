package uk.ac.cardiff.ASE2022Y2TEAM07.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.CheckinDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.CheckinRepositoryImpl;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.CheckinService;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.forms.CheckinForm;

import java.sql.Date;
import java.time.LocalDate;

@RequestMapping("employee/checkin")
@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
@Controller
public class CheckinController {

    @Autowired
    private CheckinService checkinService;

    @Autowired
    private OneToOneController oneToOneController;

    @Autowired
    public CheckinController(CheckinService checkinService) {
        this.checkinService = checkinService;
    }

    @GetMapping("")
    public ModelAndView checkinsForm(Model model, Integer employeeId){
        model.addAttribute("name", oneToOneController.getCurrentEmployee().getName());
        model.addAttribute("supervisor", "Carl");
        model.addAttribute("checkinForm",new CheckinForm(employeeId, 5));
        var mv = new ModelAndView("employee/EmployeeCheckinPage", model.asMap());
        return mv;
    }

    @PostMapping("")
    public ModelAndView checkinForm(CheckinForm checkinForm, Model model, BindingResult bindingResult) {

        // gets date
        Date now = Date.valueOf(LocalDate.now());

        CheckinDto checkinDto = new CheckinDto(null, checkinForm.getEmployeeId(), checkinForm.getScore(), now);
        checkinService.save(checkinDto);

        var mv = new ModelAndView("employee/EmployeeHomepage.html", model.asMap());
        return mv;
    }

}



