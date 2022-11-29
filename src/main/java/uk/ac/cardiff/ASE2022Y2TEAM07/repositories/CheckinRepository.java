package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Checkin;

import java.util.List;

public interface CheckinRepository {

    Checkin findByCheckInId(Integer checkinId);

    Checkin findByEmployeeId(Integer employeeId);

    Checkin findByScore(Integer score);

    List<Checkin> findAll();
}
