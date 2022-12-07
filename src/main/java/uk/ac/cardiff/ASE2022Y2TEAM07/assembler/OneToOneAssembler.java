package uk.ac.cardiff.ASE2022Y2TEAM07.assembler;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;

import java.util.List;
import java.util.stream.Collectors;

public class OneToOneAssembler {

    public static List<OneToOneDto> toDto(List<OneToOne> oneToOnes) {
        return oneToOnes
                .stream()
                .map(oto -> toDto(oto))
                .collect(Collectors.toList());
    }

    public static OneToOneDto toDto(OneToOne oto) {
        return new OneToOneDto(oto.getOneToOneID(), oto.getEmployeeID(), oto.getSupervisorID(), oto.getDate());
    }

}
