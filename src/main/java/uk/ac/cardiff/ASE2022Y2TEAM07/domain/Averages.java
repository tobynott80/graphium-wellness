package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Averages {
//    private Integer average;
//
//    private String employeeName;

    private Integer average;
    private Integer employeeId;
    private Integer supervisorId;
    private String employeeName;


    public Averages(Integer average, String employeeName, Integer employeeId) {
        this.average = average;
        this.employeeName = employeeName;
        this.employeeId = employeeId;
    }
}
