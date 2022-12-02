package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;

public interface OneToOneRepository {
    OneToOne getOneToOneById(Integer oneToOneId);

    void save(OneToOne oneToOne);

}
