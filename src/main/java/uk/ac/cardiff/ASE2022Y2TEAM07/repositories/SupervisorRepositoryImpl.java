package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;


import org.springframework.stereotype.Repository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Supervisor;

@Repository
public class SupervisorRepositoryImpl implements SupervisorRepository {


    @Override
    public Supervisor findByEmail(String email) {
        return null;
    }
}

