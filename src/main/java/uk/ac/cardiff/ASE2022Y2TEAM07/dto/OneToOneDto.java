package uk.ac.cardiff.ASE2022Y2TEAM07.dto;

import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;

@Value
public class OneToOneDto {

    private Integer One_To_One_ID;
    private Integer Employee_ID;
    private Integer Supervisor_ID;
    private LocalDate Date;

    public OneToOneDto(Integer One_To_One_ID, Integer Employee_ID, Integer Supervisor_ID, LocalDate Date) {
        this.One_To_One_ID = One_To_One_ID;
        this.Employee_ID = Employee_ID;
        this.Supervisor_ID = Supervisor_ID;
        this.Date = Date;
    }

}
