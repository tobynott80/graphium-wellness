package uk.ac.cardiff.ASE2022Y2TEAM07.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.CheckinRepositoryImpl;

@RequestMapping("{employeeId}/checkin")
@Controller
public class Checkin {

    private CheckinRepositoryImpl checkinRepository;

    public Checkin(CheckinRepositoryImpl checkinRepository) {
        this.checkinRepository = checkinRepository;
    }

    @GetMapping("")
    public ModelAndView checkinForm(Model model){
        // To do: get the name and supervisor from the database

        model.addAttribute("name","john");
        model.addAttribute("supervisor","carl");
        model.addAttribute("score", 5);
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


}
