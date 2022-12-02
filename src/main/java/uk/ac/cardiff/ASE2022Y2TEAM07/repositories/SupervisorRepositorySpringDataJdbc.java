package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Supervisor;

import java.util.Optional;

public interface SupervisorRepositorySpringDataJdbc extends CrudRepository<Supervisor, Integer> {
    Iterable<Supervisor> findAll();

    Optional<Supervisor> findById(Integer id);
    Supervisor findByEmail(String email);

    Supervisor findBySupervisorId(Integer supervisorId);


}
