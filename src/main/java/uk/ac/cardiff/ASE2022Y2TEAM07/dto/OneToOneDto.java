package uk.ac.cardiff.ASE2022Y2TEAM07.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDate;

@Value
@AllArgsConstructor
public class OneToOneDto {

    private int OneToOneId;
    private int employeeId;
    private int supervisorId;
    private LocalDate date;

    public int getOneToOneId() {
        return OneToOneId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public LocalDate getDate() {
        return date;
    }
}
