package uk.ac.cardiff.ASE2022Y2TEAM07.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.CheckinDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.CheckinService;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.forms.CheckinForm;

import java.time.LocalDate;

@RequestMapping("employee/checkin")
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
        model.addAttribute("checkinForm",new CheckinForm(oneToOneController.getCurrentEmployee().getEmployeeId(), 5));
        var mv = new ModelAndView("employee/EmployeeCheckinPage", model.asMap());
        return mv;
    }

    @PostMapping("")
    public ModelAndView checkinForm(CheckinForm checkinForm, Model model, BindingResult bindingResult) {

        Employee employee = oneToOneController.getCurrentEmployee();

        // gets date
        LocalDate now = LocalDate.now();

        CheckinDto checkinDto = new CheckinDto(null, employee.getEmployeeId(), checkinForm.getScore(), now);
        checkinService.save(checkinDto);

        var mv = new ModelAndView("employee/EmployeeHomepage.html", model.asMap());
        return mv;
    }

}



