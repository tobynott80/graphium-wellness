package uk.ac.cardiff.ASE2022Y2TEAM07.web.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckinForm {
    private Integer employeeID;
    private Integer score;
}
