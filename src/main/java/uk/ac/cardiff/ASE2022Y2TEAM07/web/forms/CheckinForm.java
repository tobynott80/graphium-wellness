package uk.ac.cardiff.ASE2022Y2TEAM07.web.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckinForm {
    private Integer employeeId;
//    @Min(value = 1,  message = "You can not checkin with a score less than 1")
//    @Max(value = 10, message = "You can not checkin with a score more than 10")
    private Integer score;

//    public CheckinForm(Integer employeeId, Integer score) {
//        this.employeeId = employeeId;
//        this.score = score;
//    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public Integer getScore() {
        return score;
    }
}
