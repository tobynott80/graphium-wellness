package uk.ac.cardiff.ASE2022Y2TEAM07.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Goal;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.GoalDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.GoalRepository;

import java.util.List;

@Service
public class GoalServiceImpl implements GoalService{

    @Autowired
    private GoalRepository goalRepository;


    @Override
    public List<GoalDto> findAll() {
        return null;
    }

    @Override
    public void save(GoalDto goalDto) {
        Goal goal = new Goal(goalDto.getGoalId(), goalDto.getEmployeeId(), goalDto.getGoal(), goalDto.getDescription(), goalDto.getTargetDate(), goalDto.getCompletedDate());
        goalRepository.save(goal);
    }

    @Override
    public Goal getGoalById(Integer goalId) {
        Goal goal = goalRepository.findByGoalId(goalId);
        return goal;
    }

    @Override
    public Goal getByEmployeeId(Integer employeeId) {
        Goal goal = goalRepository.findByEmployeeId(employeeId);
        return goal;
    }


}
