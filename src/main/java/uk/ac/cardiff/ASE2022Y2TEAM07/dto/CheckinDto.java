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
}
