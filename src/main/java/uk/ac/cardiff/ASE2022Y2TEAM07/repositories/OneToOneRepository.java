package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;

import java.util.List;
import java.util.Optional;

public interface OneToOneRepository {
    OneToOne getOneToOneById(Integer oneToOneId);

    void save(OneToOne oneToOne);

    Integer getNewestOneToOneId();


    static List<OneToOne> getOneToOnes() {
        return null;
    }

    List<OneToOne> findAll();

}
