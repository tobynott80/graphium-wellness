package uk.ac.cardiff.ASE2022Y2TEAM07.web.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckinForm {
    private Integer employeeId;
    private Integer score;

    public CheckinForm(Integer employeeId, Integer score) {
        this.employeeId = employeeId;
        this.score = score;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public Integer getScore() {
        return score;
    }
}
