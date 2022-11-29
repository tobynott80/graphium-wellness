package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;

import java.util.List;
import java.util.Optional;



public interface OneToOneRepositorySpringDataJdbc extends CrudRepository<OneToOne, Integer> {
    OneToOne findByOneToOneId(Integer oneToOneId);

    Iterable<OneToOne> findAll();

}

