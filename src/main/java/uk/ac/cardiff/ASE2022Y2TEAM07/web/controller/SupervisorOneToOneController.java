package uk.ac.cardiff.ASE2022Y2TEAM07.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Meeting;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Supervisor;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.EmployeeRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.OneToOneRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.SupervisorRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.OneToOneService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("supervisor/onetoone")
public class SupervisorOneToOneController {

    @Autowired
    private OneToOneService oneToOneService;

    @Autowired
    private OneToOneRepository oneToOneRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SupervisorRepository supervisorRepository;

    public SupervisorOneToOneController(OneToOneService otoService) {
        this.oneToOneService = otoService;
    }

    private String getCurrentSupervisorEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
    }

    public Supervisor getCurrentSupervisor() {
        String email = getCurrentSupervisorEmail();
        return supervisorRepository.findByEmail(email);
    }

    @GetMapping("")
    public ModelAndView getSupervisorOneToOnePage(Model model) {
        Supervisor currentSupervisor = this.getCurrentSupervisor();

        List<OneToOneDto> allOneToOnes = oneToOneService.findAll();
        List<OneToOneDto> releventOneToOnes = new ArrayList<>();

        List<Meeting> meetings = new ArrayList<>();

        for (OneToOneDto o: allOneToOnes) {
            if(currentSupervisor.getSupervisorId() == o.getSupervisorId()) {
                releventOneToOnes.add(o);
            }
        }

        for (OneToOneDto o: releventOneToOnes) {
            meetings.add(new Meeting(employeeRepository.findByEmployeeId(o.getEmployeeId()).getName(), o.getDate()));
        }

        model.addAttribute("meetings", meetings);

        var mv = new ModelAndView("supervisor/SupervisorOneToOne", model.asMap());
        return mv;
    }

}


//get all oneToOnes
//find out which oneToOnes correspond with which employeeId
//get the employee name from the employeeId
//display employee name

//display onetoone date

//display notes
