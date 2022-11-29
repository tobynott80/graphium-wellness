package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Checkin {
    private Integer checkInsId;
    private Integer employeeId;
    private String score;
    private String date;
}
