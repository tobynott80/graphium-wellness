package uk.ac.cardiff.ASE2022Y2TEAM07.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.OneToOneService;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.message.OneToOneListRequest;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("supervisor")
public class OneToOneController {

    private final OneToOneService oneToOneService;

    public OneToOneController(OneToOneService otoService) {
        this.oneToOneService = otoService;
    }
    @GetMapping("onetoone")
    public ModelAndView getSupervisorOneToOnePage(Model model) {
        List<OneToOneDto> oneToOnes = oneToOneService.getSupervisorOneToOnes();
        model.addAttribute("oneToOnes",oneToOnes);

        var mv = new ModelAndView("SupervisorOneToOne", model.asMap());
        return mv;
    }

    private List<OneToOneDto> getSupervisorOneToOnePage() {
        return oneToOneService.getSupervisorOneToOnes();
    }

}
