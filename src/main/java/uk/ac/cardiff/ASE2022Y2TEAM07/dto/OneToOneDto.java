package uk.ac.cardiff.ASE2022Y2TEAM07.dto;

import lombok.Value;

import java.time.LocalDate;

import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collector;


@Value
public class OneToOneDto {
    private int OneToOneId;
    private int employeeId;
    private int supervisorId;
    private LocalDate date;

    public OneToOneDto(int oneToOneId, int employeeId, int supervisorId, LocalDate date) {
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

    public LocalDate getDate() {
        return date;
    }

}
