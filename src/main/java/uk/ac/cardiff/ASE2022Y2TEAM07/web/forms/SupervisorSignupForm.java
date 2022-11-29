package uk.ac.cardiff.ASE2022Y2TEAM07.web.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SupervisorSignupForm {
    @NotEmpty
    private String name;

    @NotEmpty
    private String email;

    @NotEmpty
    private String pass;

}
