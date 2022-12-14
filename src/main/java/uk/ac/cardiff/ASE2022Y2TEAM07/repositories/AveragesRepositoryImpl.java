package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AveragesRepositoryImpl implements AveragesRepository{

    private AveragesRepositorySpringDataJdbc repoJdbc;
    private JdbcTemplate jdbc;


    public AveragesRepositoryImpl(AveragesRepositorySpringDataJdbc aRepo, JdbcTemplate jdbcTemplate) {
        this.repoJdbc = aRepo;
        jdbc = JdbcTemplate;
    }
    
}
