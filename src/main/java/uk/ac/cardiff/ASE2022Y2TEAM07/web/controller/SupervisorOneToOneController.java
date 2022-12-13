package uk.ac.cardiff.ASE2022Y2TEAM07.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.EmployeeRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.OneToOneRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.OneToOneService;

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

    public SupervisorOneToOneController(OneToOneService otoService) {
        this.oneToOneService = otoService;
    }
//    @GetMapping("onetoone")
//    public ModelAndView getSupervisorOneToOnePage(Model model) {
//        List<OneToOneDto> oneToOnes = oneToOneService.getSupervisorOneToOnes();
//        model.addAttribute("oneToOnes",oneToOnes);
//
//        var mv = new ModelAndView("supervisor/SupervisorOneToOne", model.asMap());
//        return mv;
//    }

    private List<OneToOneDto> getSupervisorOneToOnePage() {
        return oneToOneService.getSupervisorOneToOnes();
    }

    @GetMapping("")
    public ModelAndView getSupervisorOneToOnePage(Model model) {
        List<OneToOneDto> oneToOnes = oneToOneService.getSupervisorOneToOnes();



//        Employee employee = employeeRepository.findByEmployeeId();
//        model.addAttribute("EmployeeName", employee.getName());
        model.addAttribute("oneToOnes", oneToOnes);
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
