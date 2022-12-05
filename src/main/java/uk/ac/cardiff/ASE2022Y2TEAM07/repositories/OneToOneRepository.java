package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import org.springframework.stereotype.Repository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;

import java.util.List;
import java.util.Optional;

public interface OneToOneRepository {


    List<OneToOne> findAll();


    //working on this
    List<OneToOne> getOneToOnes();

//    List<OneToOne> getOneToOnesBySearch(String search);

    List<OneToOne> getOneToOnesBySearch(Integer search);
}
