package uk.ac.cardiff.ASE2022Y2TEAM07.api.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@AllArgsConstructor
@Builder(builderMethodName = "of")
public class OneToOneJson {

    private Integer oneToOneId;
    private Integer employeeId;
    private Integer supervisorId;
    private LocalDate date;

}
