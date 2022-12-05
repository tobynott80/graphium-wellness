package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@Table
public class OneToOne {

    @Id
    private Integer oneToOneID;
    private Integer employeeID;
    private Integer supervisorID;
    private LocalDate date;

   public static OneToOne of(Integer oneToOneID, Integer employeeID, Integer supervisorID, LocalDate date) {
       return new OneToOne(oneToOneID, employeeID, supervisorID, date);
   }


}
