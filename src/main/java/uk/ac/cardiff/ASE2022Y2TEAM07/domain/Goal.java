package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goal {

    @Id
    private int goalId;
    private int employeeId;
    private String goal;
    private String description;
    private Date targetDate;
    private Date CompleteDate;
}
