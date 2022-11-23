package uk.ac.cardiff.ASE2022Y2TEAM07.web.forms;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OneToOneForm {
    @NotEmpty
    private Integer employeeID;


    private String notes;
}
