package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Checkin;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.CheckinDto;

import java.util.List;

@Repository
public interface CheckinRepository {

    Checkin findByCheckInId(Integer checkinId);

    Checkin findByEmployeeId(Integer employeeId);

    Checkin findByScore(Integer score);

    List<Checkin> findAll();

    void save(Checkin checkin);
}
