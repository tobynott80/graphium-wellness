package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import org.springframework.stereotype.Repository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Goal;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GoalRepositoryImpl implements GoalRepository{

    private GoalRepositorySpringDataJdbc repoJdbc;

    @Override
    public Goal findByGoalId(Integer goalId) {
        return repoJdbc.findByGoalId(goalId);
    }

    @Override
    public Goal findByEmployeeId(Integer employeeId) {
        return repoJdbc.findByEmployeeId(employeeId);
    }

    @Override
    public List<Goal> findAll() {
        List<Goal> goals = new ArrayList<>();
        repoJdbc.findAll().forEach(goals::add);
        return goals;
    }

    @Override
    public List<Goal> findAllByEmployeeID(Integer employeeId) {
        List<Goal> goals = new ArrayList<>();
        repoJdbc.findAllByEmployeeID(employeeId).forEach(goals::add);
        return goals;
    }

    @Override
    public void save(Goal goal) {
        repoJdbc.save(goal);
    }
}
