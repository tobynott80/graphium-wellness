package uk.ac.cardiff.ASE2022Y2TEAM07.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.sql.Date;

@Value
@AllArgsConstructor
public class OneToOneDto {

    private Integer One_To_One_ID;
    private Integer Employee_ID;
    private Integer Supervisor_ID;
    private Date Date;

}
