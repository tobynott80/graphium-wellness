package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table
public class OneToOne {
    //TODO: Implement this class


    private Integer One_To_One_ID;
    private Integer Employee_ID;
    private Integer Supervisor_ID;
    private String Date;

}
