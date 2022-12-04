package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.OneToOneService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OneToOneRepositoryImpl implements OneToOneRepository{

    private OneToOneRepositorySpringDataJdbc repoJdbc;

    public OneToOneRepositoryImpl(OneToOneRepositorySpringDataJdbc aJdbcRepo) {
        repoJdbc = aJdbcRepo;
    }

    @Override
    public List<OneToOne> findAll() {
        List<OneToOne> onetoone = new ArrayList<>();
        repoJdbc.findAll().forEach(onetoone::add);
        return onetoone;
    }

    @Override
    public List<OneToOne> getOneToOnes() {
        List<OneToOne> oneToOnes = new ArrayList<>();
        repoJdbc.findAll().forEach(oneToOnes::add);
        return oneToOnes;
    }


}
