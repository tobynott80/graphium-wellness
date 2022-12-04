package uk.ac.cardiff.ASE2022Y2TEAM07.service;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.NoteDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.message.*;

import java.util.List;

public interface OneToOneService {



    void save(OneToOneDto oneToOneDto, NoteDto noteDto);

    List<OneToOneDto> findAll();

    OneToOne getOneToOneById(Integer OneToOneId);

    OneToOneListResponse getAllOneToOne(OneToOneListRequest onetooneListRequest);

    //
    OneToOneListResponse getOneToOnes(OneToOneListRequest listRequest);

}
