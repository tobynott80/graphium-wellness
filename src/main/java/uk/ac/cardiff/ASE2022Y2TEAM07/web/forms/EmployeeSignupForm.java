package uk.ac.cardiff.ASE2022Y2TEAM07.web.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSignupForm {
    @NotEmpty
    private String name;

    @NotEmpty
    private String email;


    private String role;

    @NotEmpty
    private String pass;

    @NotEmpty
    private Integer supervisorID;

}
