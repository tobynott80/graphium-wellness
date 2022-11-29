package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OneToOneRepositoryImpl implements OneToOneRepository{

    private OneToOneRepositorySpringDataJdbc repoJdbc;

    public OneToOneRepositoryImpl(OneToOneRepositorySpringDataJdbc aRepo) {
        repoJdbc = aRepo;
    }

    @Override
    public List<OneToOne> findAll() {
        List<OneToOne> onetoone = new ArrayList<>();
        repoJdbc.findAll().forEach(onetoone::add);
        return onetoone;
    }

    @Override
    public <S extends OneToOne> S save(S entity) {
        return null;
    }

    @Override
    public <S extends OneToOne> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<OneToOne> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    Iterable<OneToOne> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(OneToOne entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends OneToOne> entities) {

    }

    @Override
    public void deleteAll() {

    }

}
