package uk.ac.cardiff.ASE2022Y2TEAM07.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Checkin;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.CheckinRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.EmployeeRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.CheckinServiceImpl;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.EmployeeServiceImpl;

import java.util.*;


@Controller
@PreAuthorize("hasRole('ROLE_SUPERVISOR')")
@RequestMapping("/supervisor")
public class SupervisorCheckinController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CheckinRepository checkinRepository;

    @Autowired
    private CheckinServiceImpl checkinService;

    @GetMapping("")
    public ModelAndView getAllEmployees(Model model){

        Map<Integer, Integer> avgCheckins = checkinService.getAvg();

        List<Averages> averagesList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: avgCheckins.entrySet()) {
            averagesList.add(new Averages(entry.getValue(), employeeRepository.findByEmployeeId(entry.getKey()).getName()));
        }

        model.addAttribute("Employees", averagesList);

        var mv = new ModelAndView("supervisor/SupervisorPage", model.asMap());
        return mv;
    }

    @GetMapping("/employee/{furl}")
    public ModelAndView getEmployeeCheckinHistoryPage(@PathVariable("furl") Optional<Integer> furl, Model model) {
        Employee employee = employeeRepository.findByEmployeeId(furl.get());
        model.addAttribute("EmployeeName", employee.getName());
        model.addAttribute("checkins", checkinRepository.findAllByEmployeeId(furl.get()).stream().toList());
        var mv = new ModelAndView("supervisor/EmployeeCheckinHistory", model.asMap());
        return mv;
    }

}
