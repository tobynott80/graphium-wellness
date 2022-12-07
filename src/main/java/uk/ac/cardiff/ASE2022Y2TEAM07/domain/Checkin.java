package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;


@Data
@Table("CHECK_INS")
@Builder
public class Checkin {

    @Id
    private Integer checkInsId;
    private Integer employeeId;
    private Integer score;
    private LocalDate date;

    public Checkin(Integer checkInsId, Integer employeeId, Integer score, LocalDate date) {
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

}
