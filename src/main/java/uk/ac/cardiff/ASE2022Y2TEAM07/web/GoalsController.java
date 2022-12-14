package uk.ac.cardiff.ASE2022Y2TEAM07.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Goal;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.GoalRepository;

import java.util.List;

@RequestMapping("employee/goals")
@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
@Controller
public class GoalsController {

    @Autowired
    private final GoalRepository goalRepository;

    @Autowired
    private final OneToOneController oneToOneController;

    public GoalsController(GoalRepository goalRepository, OneToOneController oneToOneController) {
        this.goalRepository = goalRepository;
        this.oneToOneController = oneToOneController;
    }

    @GetMapping("")
    public ModelAndView personalGoals(Model model) {
        int em = oneToOneController.getCurrentEmployee().getEmployeeId();
        List<Goal> goals = goalRepository.findAllByEmployeeId(em);

        model.addAttribute("employeeGoals", goals);

        var mv = new ModelAndView("employee/EmployeePersonalGoalsPage", model.asMap());
        return mv;
    }
}
