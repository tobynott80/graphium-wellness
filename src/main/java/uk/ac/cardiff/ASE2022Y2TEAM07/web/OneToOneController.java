package uk.ac.cardiff.ASE2022Y2TEAM07.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.OneToOneService;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.forms.OneToOneForm;

@Controller
@RequestMapping("employee/onetoone")
public class OneToOneController {
    private final OneToOneService oneToOneService;

    public OneToOneController(OneToOneService oneToOneService) {
        this.oneToOneService = oneToOneService;
    }

    @GetMapping("")
    public ModelAndView getOneToOneForm (Model model) {
        model.addAttribute("oneToOneForm", new OneToOneForm());
        var mv = new ModelAndView("EmployeeOneToOnePage", model.asMap());
        return mv;
    }
}
