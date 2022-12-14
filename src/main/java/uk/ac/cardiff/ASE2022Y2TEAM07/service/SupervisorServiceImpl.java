package uk.ac.cardiff.ASE2022Y2TEAM07.service;

import org.springframework.stereotype.Service;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.SupervisorDto;

import java.util.List;

@Service
public class SupervisorServiceImpl implements SupervisorService{
    @Override
    public List<SupervisorDto> findAll() {
        return null;
    }

    @Override
    public List<SupervisorDto> findAllSupervisors1to1s(Integer supervisorID) {
        return null;
    }

    @Override
    public List<SupervisorDto> findAllSupervisorsCheckins(Integer supervisorID) {
        return null;
    }
}
