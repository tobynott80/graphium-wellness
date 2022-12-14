package uk.ac.cardiff.ASE2022Y2TEAM07.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class AveragesDto {

    private Integer average;
    private Integer employeeId;
    private Integer supervisorId;

    public Integer getAverage() {
        return average;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public Integer getSupervisorId() {
        return supervisorId;
    }
}
