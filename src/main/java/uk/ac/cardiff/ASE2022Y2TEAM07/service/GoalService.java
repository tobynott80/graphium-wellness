package uk.ac.cardiff.ASE2022Y2TEAM07.service;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Goal;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.GoalDto;

import java.util.List;

public interface GoalService {

    List<GoalDto> findAll();

    void save(GoalDto goalDto);

    Goal getGoalById(Integer goalId);

    Goal getByEmployeeId(Integer employeeId);
}
