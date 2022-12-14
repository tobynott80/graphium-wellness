package uk.ac.cardiff.ASE2022Y2TEAM07.service.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;

import java.util.Collection;
import java.util.List;

@Value
@AllArgsConstructor
@Builder(builderMethodName="of")
public class OneToOneListResponse {

    private OneToOneListRequest request;
    private List<OneToOneDto> oneToOnes;

    public Integer getOneToOneCount() {
        return oneToOnes.size();
    }

}
