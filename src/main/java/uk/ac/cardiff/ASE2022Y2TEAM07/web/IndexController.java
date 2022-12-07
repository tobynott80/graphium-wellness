package uk.ac.cardiff.ASE2022Y2TEAM07.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    private String getUserRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserRole = authentication.getAuthorities().toString();
        return currentUserRole;
    }

    @GetMapping
    public String redirectUser() {
        if (getUserRole().equals("[ROLE_SUPERVISOR]")) {
            return "redirect:/supervisor";
        } else if (getUserRole().equals("[ROLE_EMPLOYEE]")) {
            return "redirect:/employee";
        } else {
            return "redirect:/login";
        }
    }

}
