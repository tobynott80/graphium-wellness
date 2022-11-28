package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Supervisor;

public interface SupervisorRepository {
    Supervisor findByEmail(String email);
}
