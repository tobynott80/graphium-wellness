package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Checkin;

import java.time.LocalDate;
import java.util.Optional;

public interface CheckinRepositorySpringDataJdbc extends CrudRepository<Checkin, Integer> {

    Iterable<Checkin> findAll();

    Optional<Checkin> findById(Integer id);

    Checkin findByEmployeeId(Integer employeeId);

    Checkin findByScore(Integer score);

    Checkin findByCheckInsId(Integer checkInId);

    Iterable<Checkin> findAllByEmployeeId(Integer employeeId);
}
