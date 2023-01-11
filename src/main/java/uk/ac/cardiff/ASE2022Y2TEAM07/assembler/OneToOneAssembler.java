package uk.ac.cardiff.ASE2022Y2TEAM07.assembler;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Assembles OneToOne objects into OneToOneDto objects.
 */
public class OneToOneAssembler {

    /**
     * Assembles a list OneToOne objects into a list OneToOneDto objects.
     * @param oneToOnes the OneToOne objects to assemble
     * @return a list of OneToOneDto objects
     */
    public static List<OneToOneDto> toDto(List<OneToOne> oneToOnes) {
        return oneToOnes
                .stream()
                .map(oto -> toDto(oto))
                .collect(Collectors.toList());
    }

    /**
     * Assembles a OneToOne object into a OneToOneDto object.
     * @param oto the OneToOne object to assemble
     * @return a OneToOneDto object
     */
    public static OneToOneDto toDto(OneToOne oto) {
        return new OneToOneDto(oto.getOneToOneId(), oto.getEmployeeId(), oto.getSupervisorId(), oto.getDate());
    }

}
