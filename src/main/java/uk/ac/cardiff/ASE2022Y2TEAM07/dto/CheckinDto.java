package uk.ac.cardiff.ASE2022Y2TEAM07.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.sql.Date;

/**
 * Checkin data transfer object class. Contains the information for a checkin.
 */
@Value
@AllArgsConstructor
public class CheckinDto {
    private Integer checkInsId;
    private Integer employeeId;
    private Integer score;
    private Date date;


    public Integer getCheckInsId() {
        return checkInsId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public Integer getScore() {
        return score;
    }

    public Date getDate() {
        return date;
    }
}
