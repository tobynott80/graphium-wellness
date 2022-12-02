package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;

import java.util.List;
import java.util.Optional;

public interface OneToOneRepository {

    static List<OneToOne> getOneToOnes() {
        return null;
    }

    List<OneToOne> findAll();

    //


    List<OneToOne> getAllOneToOne();


    //

    <S extends OneToOne> S save(S entity);

    <S extends OneToOne> Iterable<S> saveAll(Iterable<S> entities);

    Optional<OneToOne> findById(Integer integer);

    boolean existsById(Integer integer);

    long count();

    void deleteById(Integer integer);

    void delete(OneToOne entity);

    void deleteAllById(Iterable<? extends Integer> integers);

    void deleteAll(Iterable<? extends OneToOne> entities);

    void deleteAll();
}
