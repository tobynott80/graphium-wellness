package uk.ac.cardiff.ASE2022Y2TEAM07.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Goal;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.GoalDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.GoalRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.GoalService;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.forms.CheckinForm;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.forms.GoalForm;

import java.util.List;

@RequestMapping("employee/goals")
@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
@Controller
public class GoalsController {

    @Autowired
    private final GoalRepository goalRepository;

    @Autowired
    private final OneToOneController oneToOneController;

    @Autowired
    private final GoalService goalService;

    public GoalsController(GoalRepository goalRepository, OneToOneController oneToOneController, GoalService goalService) {
        this.goalRepository = goalRepository;
        this.oneToOneController = oneToOneController;
        this.goalService = goalService;
    }

    @GetMapping("")
    public ModelAndView personalGoals(Model model) {
        int em = oneToOneController.getCurrentEmployee().getEmployeeId();
        List<Goal> goals = goalRepository.findAllByEmployeeId(em);

        model.addAttribute("employeeGoals", goals);
        model.addAttribute("goalForm", new GoalForm());

        var mv = new ModelAndView("employee/EmployeePersonalGoalsPage", model.asMap());
        return mv;
    }

    @PostMapping("")
    public ModelAndView personalGoal(Model model, GoalForm goalForm, BindingResult bindingResult) {
        Employee em = oneToOneController.getCurrentEmployee();

//        model.addAttribute("goalFrom", goalForm);

        GoalDto goalDto = new GoalDto(null, em.getEmployeeId(), goalForm.getTitle(), goalForm.getDescription(), goalForm.getTargetDate());
        goalService.save(goalDto);

        var mv = new ModelAndView("redirect:/employee/goals", model.asMap());
        return mv;
    }

}
