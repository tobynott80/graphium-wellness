package uk.ac.cardiff.ASE2022Y2TEAM07.web.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoalForm {

    private int goalId;
    private int employeeId;
    private String title;
    private String description;
    private Date targetDate;
    private Date completedDate;
}
