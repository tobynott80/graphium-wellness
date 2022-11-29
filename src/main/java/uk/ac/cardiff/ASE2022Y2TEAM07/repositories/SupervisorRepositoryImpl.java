package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;


import org.springframework.stereotype.Repository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Supervisor;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SupervisorRepositoryImpl implements SupervisorRepository {

    private SupervisorRepositorySpringDataJdbc repoJdbc;

    public SupervisorRepositoryImpl(SupervisorRepositorySpringDataJdbc aRepo) {
        repoJdbc = aRepo;
    }

    @Override
    public Supervisor findBySupervisorId(Integer supervisorId) {
        return repoJdbc.findBySupervisorId(supervisorId);
    }
    @Override
    public Supervisor findByEmail(String email) {
        return repoJdbc.findByEmail(email);
    }

    @Override
    public List<Supervisor> findAll() {
        List<Supervisor> supervisors = new ArrayList<>();
        repoJdbc.findAll().forEach(supervisors::add);
        return supervisors;
    }
}

