package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table("CHECK_INS")
public class Checkin {
    @Id
    private Integer checkInsId;
    private Integer employeeId;
    private String score;
    private String date;
}
