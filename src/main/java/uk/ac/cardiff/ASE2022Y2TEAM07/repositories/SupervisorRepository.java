package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Supervisor;

import java.util.List;

public interface SupervisorRepository {
    Supervisor findBySupervisorId(Integer supervisorId);

    Supervisor findByEmail(String email);

    List<Supervisor> findAll();
}
