package uk.ac.cardiff.ASE2022Y2TEAM07.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Averages;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Supervisor;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.EmployeeDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.CheckinRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.EmployeeRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.SupervisorRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.CheckinServiceImpl;

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
    @Autowired
    private SupervisorRepository supervisorRepository;

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
    public ModelAndView getAllEmployees(Model model){
        Supervisor currentSupervisor = this.getCurrentSupervisor();

        List<Averages> relevantEmployees = new ArrayList<>();

        Map<Integer, Integer> avgCheckins = checkinService.getAvg();

        List<Averages> averagesList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: avgCheckins.entrySet()) {
            averagesList.add(new Averages(entry.getValue(), employeeRepository.findByEmployeeId(entry.getKey()).getName(), entry.getKey(), employeeRepository.findByEmployeeId(entry.getKey()).getSupervisorId()));
        }

        for (Averages a : averagesList) {
            if (currentSupervisor.getSupervisorId() == a.getSupervisorId()) {
                relevantEmployees.add(a);
            }
        }

        model.addAttribute("Employees", relevantEmployees);

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
