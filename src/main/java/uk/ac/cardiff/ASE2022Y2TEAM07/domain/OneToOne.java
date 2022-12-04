package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Data
@AllArgsConstructor
@Table
public class OneToOne {

    //TODO: Implement this class

    @Id
    private Integer One_To_One_ID;
    private Integer Employee_ID;
    private Integer Supervisor_ID;
    private java.sql.Date Date;

   public static OneToOne of(Integer One_To_One_ID, Integer Employee_ID, Integer Supervisor_ID, Date Date) {
       return new OneToOne(One_To_One_ID, Employee_ID, Supervisor_ID, Date);
   }

}
