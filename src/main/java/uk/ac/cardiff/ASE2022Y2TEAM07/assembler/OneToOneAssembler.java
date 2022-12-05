package uk.ac.cardiff.ASE2022Y2TEAM07.assembler;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;

public class OneToOneAssembler {

    //TODO: Implement this class

    public static OneToOneDto toDto(OneToOne oto) {
        return new OneToOneDto(oto.getOneToOneID(), oto.getEmployeeID(), oto.getSupervisorID(), oto.getDate());
    }

}
