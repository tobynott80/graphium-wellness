package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Goal;

import java.util.List;

/**
 *  Checkin repository interface. Contains the methods for accessing the checkin table in the database.
 */
public interface GoalRepository {

    Goal findByGoalId(Integer goalId);

    Goal findByEmployeeId(Integer employeeId);

    List<Goal> findAll();

    List<Goal> findAllByEmployeeId(Integer employeeId);

    void save(Goal goal);
}
