package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import org.springframework.stereotype.Repository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Checkin;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.CheckinDto;

import java.util.List;

/**
 * Checkin repository interface. Contains the methods for accessing the checkin table in the database.
 */
public interface CheckinRepository {

    /**
     * Finds checkin by check in id.
     * @param checkinId the id of the checkin to be retrieved
     * @return the checkin with the given id
     */
    Checkin findByCheckInId(Integer checkinId);

    /**
     * Finds checkin by score. Used for testing only
     * @param score the score of the checkin to be retrieved
     * @return the checkin with the given score
     */
    Checkin findByScore(Integer score);

    /**
     * Finds all checkins.
     * @return all checkins in the database
     */
    List<Checkin> findAll();


    /**
     * Finds all checkins by employee id.
     * @param employeeId the id of the employee whose checkins are to be retrieved
     * @return all checkins for the given employee
     */
    List<Checkin> findAllByEmployeeId(Integer employeeId);

    /**
     * Saves a checkin to the database.
     * @param checkin the checkin to be saved
     */
    void save(Checkin checkin);

    /**
     * Gets a checkin by check in id.
     * @param checkInsId the id of the checkin to be retrieved
     * @return the checkin with the given id
     */
    Checkin getCheckinById(Integer checkInsId);

    /**
     * @return List of checkin averages for each employee
     */
    List<Checkin> findEmployeeWithAvg();
}
