package uk.ac.cardiff.ASE2022Y2TEAM07.service;

import uk.ac.cardiff.ASE2022Y2TEAM07.dto.SupervisorDto;

import java.util.List;

public interface SupervisorService {
    List<SupervisorDto> findAll();

    List<SupervisorDto> findAllSupervisors1to1s(Integer supervisorID);

    List<SupervisorDto> findAllSupervisorsCheckins(Integer supervisorID);


    //TODO: implement findAll method
    //TODO: implement findAllSupervisors1to1s method
    //TODO: implement findAllSupervisorsCheckins method
}
