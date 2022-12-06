package uk.ac.cardiff.ASE2022Y2TEAM07.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.CheckinDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.CheckinRepositoryImpl;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.CheckinService;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.forms.CheckinForm;

import java.time.LocalDate;

@RequestMapping("employee/{employeeId}/checkin")
@Controller
public class CheckinController {

    @Autowired
    private CheckinService checkinService;

    @Autowired
    public CheckinController(CheckinService checkinService) {
        this.checkinService = checkinService;
    }

    @GetMapping("")
    public ModelAndView checkinsForm(Model model, @PathVariable("employeeId") Integer employeeId){
        model.addAttribute("name","John");
        model.addAttribute("supervisor", "Carl");
        model.addAttribute("checkinForm",new CheckinForm(employeeId, 5));
        var mv = new ModelAndView("employee/EmployeeCheckinPage", model.asMap());
        return mv;
    }

    @PostMapping("")
    public ModelAndView checkinForm(CheckinForm checkinForm, @PathVariable Integer employeeId, Model model, BindingResult bindingResult) {

        // gets date
        LocalDate now = LocalDate.now();

        CheckinDto checkinDto = new CheckinDto(null, checkinForm.getEmployeeId(), checkinForm.getScore(), now);
        checkinService.save(checkinDto);

        var mv = new ModelAndView("employee/EmployeeHomepage.html", model.asMap());
        return mv;
    }

}



