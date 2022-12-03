package uk.ac.cardiff.ASE2022Y2TEAM07.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
public class OneToOneDto {

    private int OneToOneId;
    private int employeeId;
    private int supervisorId;
    private LocalDateTime date;

    public OneToOneDto(int oneToOneId, int employeeId, int supervisorId, LocalDateTime date) {
        OneToOneId = oneToOneId;
        this.employeeId = employeeId;
        this.supervisorId = supervisorId;
        this.date = date;
    }

    public int getOneToOneId() {
        return OneToOneId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public LocalDateTime getDate() {
        return date;
    }


}
