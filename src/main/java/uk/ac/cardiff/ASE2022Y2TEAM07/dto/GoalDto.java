package uk.ac.cardiff.ASE2022Y2TEAM07.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.Date;

@Value
@AllArgsConstructor
public class GoalDto {

    private int goalId;
    private int employeeId;
    private String goal;
    private String description;
    private Date targetDate;
    private Date CompleteDate;
}
