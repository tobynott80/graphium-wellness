package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Goal;

import java.util.List;

public interface GoalRepository {

    Goal findByGoalId(Integer goalId);

    Goal findByEmployeeId(Integer employeeId);

    List<Goal> findAll();

    List<Goal> findAllByEmployeeId(Integer employeeId);

    void save(Goal goal);
}
