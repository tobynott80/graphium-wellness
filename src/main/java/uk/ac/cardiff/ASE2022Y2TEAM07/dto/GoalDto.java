package uk.ac.cardiff.ASE2022Y2TEAM07.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.Date;

/**
 * Goal data transfer object class. Contains the information for a goal.
 */
@Value
@AllArgsConstructor
public class GoalDto {

    private Integer goalId;
    private int employeeId;
    private String title;
    private String description;
    private Date targetDate;
}
