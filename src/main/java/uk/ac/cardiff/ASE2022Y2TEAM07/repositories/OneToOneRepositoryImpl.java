package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import org.springframework.stereotype.Repository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OneToOneRepositoryImpl implements OneToOneRepository{

    private OneToOneRepositorySpringDataJdbc repoJdbc;

    public OneToOneRepositoryImpl(OneToOneRepositorySpringDataJdbc aJdbcRepo) {
        repoJdbc = aJdbcRepo;
    }

    @Override
    public List<OneToOne> findAll() {
        List<OneToOne> oneToOnes = new ArrayList<>();
        repoJdbc.findAll().forEach(oneToOnes::add);
        return oneToOnes;
    }

    @Override
    public List<OneToOne> getOneToOnes() {
        List<OneToOne> oneToOnes = new ArrayList<>();
        repoJdbc.findAll().forEach(oneToOnes::add);
        return oneToOnes;
    }

    @Override
    public List<OneToOne> getOneToOnesBySearch(Integer search) {
        return repoJdbc.findByOneToOneIDContaining(search);
    }

}
