package uk.ac.cardiff.ASE2022Y2TEAM07.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.sql.Date;

@Value
@AllArgsConstructor
public class CheckinDto {
    private Integer checkInsId;
    private Integer employeeId;
    private Integer score;
    private Date date;

/*    public CheckinDto(Integer checkInsId, Integer employeeId, Integer score, Date date) {
        this.checkInsId = checkInsId;
        this.employeeId = employeeId;
        this.score = score;
        this.date = date;
    }*/

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
