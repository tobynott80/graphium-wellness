package uk.ac.cardiff.ASE2022Y2TEAM07.web.forms;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SupervisorSignupForm {
    private String name;
    private String email;
    private String pass;

    public SupervisorSignupForm() {
        this("", "", "");
    }
}
