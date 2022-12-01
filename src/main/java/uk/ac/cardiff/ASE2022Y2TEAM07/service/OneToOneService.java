package uk.ac.cardiff.ASE2022Y2TEAM07.service;

import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;

import java.util.List;

public interface OneToOneService {
    void save();

    List<OneToOneDto> findAll();

}
