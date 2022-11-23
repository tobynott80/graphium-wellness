package uk.ac.cardiff.ASE2022Y2TEAM07.web.forms;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
