package uk.ac.cardiff.ASE2022Y2TEAM07.api.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder(builderMethodName="of")
public class OneToOneJson {

    private Integer One_To_One_ID;
    private Integer Employee_ID;
    private Integer Supervisor_ID;
    private String Date;

}
