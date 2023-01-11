package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Averages class. Contains the average of the employee's checkins and one to ones.
 */
@Data
public class Averages {

    private Integer average;
    private String employeeName;
    private Integer employeeId;
    private Integer supervisorId;

    public Averages(Integer average, String employeeName, Integer employeeId, Integer supervisorId) {
        this.average = average;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.supervisorId = supervisorId;
    }

}
