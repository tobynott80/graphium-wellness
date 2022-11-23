package uk.ac.cardiff.ASE2022Y2TEAM07.web.forms;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class EmployeeSignupForm {
    private String name;
    private String email;
    private String role;
    private String pass;
    private Integer supervisorID;

    public EmployeeSignupForm() {
        this("", "", "", "", 0);
    }
}
