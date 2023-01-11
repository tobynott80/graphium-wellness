package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;


/**
 * Checkin class. Contains the information for a checkin.
 */
@Data
@Table("CHECK_INS")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Checkin {

    @Id
    private Integer checkInsId;
    private Integer employeeId;

    @Column("SCORE")
    private Integer score;
    private Date date;

    public Checkin(Integer employeeId, Integer score) {
        this.employeeId = employeeId;
        this.score = score;
    }
}
