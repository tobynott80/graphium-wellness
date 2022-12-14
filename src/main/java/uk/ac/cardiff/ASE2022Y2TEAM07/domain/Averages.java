package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Averages {
//    private Integer average;
//
//    private String employeeName;


    //--------------------------------------------------
    private Integer average;
    private Integer employeeId;
    private Integer supervisorId;

    public Averages(Integer average, Integer employeeId) {
        this.average = average;
        this.employeeId = employeeId;
    }
    //--------------------------------------------------

}
