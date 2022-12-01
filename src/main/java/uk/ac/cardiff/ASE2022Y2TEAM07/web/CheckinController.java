package uk.ac.cardiff.ASE2022Y2TEAM07.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Checkin;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.CheckinRepositoryImpl;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.message.ResponseTransfer;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.forms.CheckinForm;

import java.time.LocalDate;

@RequestMapping("employee/{employeeId}/checkin")
@Controller
public class CheckinController {

    private CheckinRepositoryImpl checkinRepository;

    public CheckinController(CheckinRepositoryImpl checkinRepository) {
        this.checkinRepository = checkinRepository;
    }

    @GetMapping("")
    public ModelAndView checkinForm(Model model, @PathVariable String employeeId){
        // To do: get the name and supervisor from the database

        model.addAttribute("name","john");
        model.addAttribute("supervisor","carl");
        model.addAttribute("score", 10);
        var mv = new ModelAndView("/EmployeeCheckinPage", model.asMap());
        return mv;
    }

    // post
    // path request parameter employeeId
    // send all fields in the checkins table to the repo
    // save the fields into the database
//    @PostMapping("form")
//    public ModelAndView checkinForm(Model model,EmployeeCheckinPage employeeCheckinPage) {
//
//    }

    @PostMapping("")
    public ModelAndView checkinForm(@RequestBody CheckinForm checkinForm, @PathVariable String employeeId, Model model) {

        // gets date
        LocalDate now = LocalDate.now();

        Checkin checkin = new Checkin(null, checkinForm.getEmployeeID(), checkinForm.getScore(), now);
        checkinRepository.save(checkin);

        var mv = new ModelAndView("redirect:/homepage", model.asMap());
        return mv;

//        return new ResponseTransfer("Checkin created successfully", "200");
    }

}



