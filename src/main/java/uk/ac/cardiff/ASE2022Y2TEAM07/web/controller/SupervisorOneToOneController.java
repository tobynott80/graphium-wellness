package uk.ac.cardiff.ASE2022Y2TEAM07.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.OneToOneService;

import java.util.List;

@Controller
@RequestMapping("supervisor")
public class SupervisorOneToOneController {

    private final OneToOneService oneToOneService;

    public SupervisorOneToOneController(OneToOneService otoService) {
        this.oneToOneService = otoService;
    }
    @GetMapping("onetoone")
    public ModelAndView getSupervisorOneToOnePage(Model model) {
        List<OneToOneDto> oneToOnes = oneToOneService.getSupervisorOneToOnes();
        model.addAttribute("oneToOnes",oneToOnes);

        var mv = new ModelAndView("supervisor/SupervisorOneToOne", model.asMap());
        return mv;
    }

    private List<OneToOneDto> getSupervisorOneToOnePage() {
        return oneToOneService.getSupervisorOneToOnes();
    }

}
