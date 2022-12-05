package uk.ac.cardiff.ASE2022Y2TEAM07.dto;

import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;

@Value
public class OneToOneDto {
    private Integer oneToOneID;
    private Integer employeeID;
    private Integer supervisorID;
    private LocalDate date;

    public OneToOneDto(Integer oneToOneID, Integer employeeID, Integer supervisorID, LocalDate date) {
        this.oneToOneID = oneToOneID;
        this.employeeID = employeeID;
        this.supervisorID = supervisorID;
        this.date = date;
    }



}
