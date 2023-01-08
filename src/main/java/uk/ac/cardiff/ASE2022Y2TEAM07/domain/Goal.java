package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

/**
 * Goal class. Contains the information for a goal.
 */
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goal {

    @Id
    private Integer goalId;
    private int employeeId;
    private String title;
    private String description;
    private Date targetDate;
}
