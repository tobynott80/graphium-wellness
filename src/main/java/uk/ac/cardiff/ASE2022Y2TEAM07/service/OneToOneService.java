package uk.ac.cardiff.ASE2022Y2TEAM07.service;

import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.message.*;

import java.util.List;

public interface OneToOneService {

    List<OneToOneDto> findAll();

    //
    OneToOneListResponse getOneToOnes();

}
