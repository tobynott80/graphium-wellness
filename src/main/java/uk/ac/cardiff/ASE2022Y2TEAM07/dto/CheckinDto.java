package uk.ac.cardiff.ASE2022Y2TEAM07.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDate;

@Value
@AllArgsConstructor
public class CheckinDto {
    private Integer checkInsId;
    private Integer employeeId;
    private Integer score;
    private LocalDate date;

    public CheckinDto(Integer checkInsId, Integer employeeId, Integer score, LocalDate date) {
        this.checkInsId = checkInsId;
        this.employeeId = employeeId;
        this.score = score;
        this.date = date;
    }

    public Integer getCheckInsId() {
        return checkInsId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public Integer getScore() {
        return score;
    }

    public LocalDate getDate() {
        return date;
    }
}
