package uk.ac.cardiff.ASE2022Y2TEAM07.service;

import uk.ac.cardiff.ASE2022Y2TEAM07.dto.CheckinDto;

import java.util.List;

public interface CheckinService {
    List<CheckinDto> findAll();
}