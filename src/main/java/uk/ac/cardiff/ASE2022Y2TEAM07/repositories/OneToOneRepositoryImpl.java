package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;


import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@Repository
public class OneToOneRepositoryImpl implements OneToOneRepository{

    private OneToOneRepositorySpringDataJdbc repoJdbc;

    public OneToOneRepositoryImpl(OneToOneRepositorySpringDataJdbc aJdbcRepo) {
        repoJdbc = aJdbcRepo;
    }

    @Override
    public OneToOne getOneToOneById(Integer oneToOneId) {
        OneToOne oneToOne = repoJdbc.findByOneToOneId(oneToOneId);
        return oneToOne;
    }

//    public Optional<OneToOne> findOneToOneById() {
//        return null;
//    }

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
        return repoJdbc.findByOneToOneIdContaining(search);
    }

    @Override
    public List<OneToOne> getEmployeeIds() {
        return null;
    }


    // -------------------------------------------------------------------------
//    public Optional<OneToOne> getEmployeeId(Integer oneToOneId) {
//        var oneToOnes = repoJdbc.findByOneToOneIds(oneToOneId);
//        return oneToOnes;
//    }

}


