package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import org.springframework.stereotype.Repository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;

import java.util.List;
import java.util.Optional;

public interface OneToOneRepository {

    OneToOne getOneToOneById(Integer oneToOneId);

    void save(OneToOne oneToOne);

    Integer getNewestOneToOneId();


    List<OneToOne> findAll();


    List<OneToOne> getOneToOnes();


    List<OneToOne> getOneToOnesBySearch(Integer search);


    //working on this
//    Optional<OneToOne> findByOneToOneId(Integer oneToOneId);

    List<OneToOne> getEmployeeIds();
}
