package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Goal;

import java.util.List;

public interface GoalRepositorySpringDataJdbc extends CrudRepository<Goal, Integer> {

    Goal findByGoalId(Integer goalId);

    Goal findByEmployeeId(Integer employeeId);

    List<Goal> findAll();

    List<Goal> findAllByEmployeeID(Integer employeeId);
}
