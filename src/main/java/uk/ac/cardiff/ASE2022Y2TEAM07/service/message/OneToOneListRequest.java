package uk.ac.cardiff.ASE2022Y2TEAM07.service.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder(builderMethodName="of")
public class OneToOneListRequest {

    private String searchTerm;
    public Boolean hasSearchTerm() {
        return (searchTerm != null);
    }

}
