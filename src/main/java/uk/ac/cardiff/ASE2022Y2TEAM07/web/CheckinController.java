package uk.ac.cardiff.ASE2022Y2TEAM07.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Checkin;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.CheckinRepositoryImpl;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.CheckinRepositorySpringDataJdbc;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.forms.CheckinForm;

import java.time.LocalDate;

@RequestMapping("employee/{employeeId}/checkin")
@Controller
public class CheckinController {

    @Autowired
    private CheckinRepositoryImpl checkinRepository;

    @Autowired
    private CheckinRepositorySpringDataJdbc checkinRepositorySpringDataJdbc;

    @Autowired
    public CheckinController(CheckinRepositoryImpl checkinRepository) {
        this.checkinRepository = checkinRepository;
    }

    @GetMapping("")
    public ModelAndView checkinsForm(Model model, @PathVariable("employeeId") Integer employeeId){
        model.addAttribute("name","John");
        model.addAttribute("supervisor", "Carl");
        model.addAttribute("checkinForm",new CheckinForm(employeeId, 10));
        var mv = new ModelAndView("/EmployeeCheckinPage", model.asMap());
        return mv;
    }

    @PostMapping("")
    public ModelAndView checkinForm(CheckinForm checkinForm, @PathVariable Integer employeeId, Model model, BindingResult bindingResult) {

        // gets date
        LocalDate now = LocalDate.now();

        Checkin checkin = new Checkin(null, checkinForm.getEmployeeId(), checkinForm.getScore(), now);
        checkinRepository.save(checkin);

        var mv = new ModelAndView("redirect:/homepage", model.asMap());
        return mv;

//        return new ResponseTransfer("Checkin created successfully", "200");
    }

}



