package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OneToOneRepositoryImpl implements OneToOneRepository {

    private OneToOneRepositorySpringDataJdbc repoJdbc;


    public OneToOneRepositoryImpl(OneToOneRepositorySpringDataJdbc aRepo) {
        repoJdbc = aRepo;
    }

    @Override
    public OneToOne getOneToOneById(Integer oneToOneId) {
        OneToOne oneToOne = repoJdbc.findByOneToOneId(oneToOneId);
        return oneToOne;
    }

    @Override
    public void save(OneToOne oneToOne) {
        repoJdbc.save(oneToOne);
    }

    @Override
    public Integer getNewestOneToOneId() {
        List<OneToOne> OneToOnes = new ArrayList<>();
        repoJdbc.findAll().forEach(OneToOnes::add);
        return OneToOnes.size();
    }
}
