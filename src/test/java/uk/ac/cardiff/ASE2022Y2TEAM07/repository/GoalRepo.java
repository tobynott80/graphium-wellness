package uk.ac.cardiff.ASE2022Y2TEAM07.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Goal;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.GoalRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GoalRepo {

    @Autowired
    private GoalRepository goalRepository;

    @Test
    public void shouldGetGoal() throws Exception {
        Integer employeeID = 1;
        Goal goal1 = goalRepository.findByEmployeeId(employeeID);
        assertEquals(1, goal1.getGoalId());
    }

    @Test
    public void shouldGetGoalById() throws Exception {
        Integer goalId = 6;
        Goal employeeId6 = goalRepository.findByGoalId(goalId);
        assertEquals(6, employeeId6.getEmployeeId());
    }

    @Test
    public void shouldGetAllGoals() throws Exception {
        int numberOfGoals = goalRepository.findAll().size();
        assertEquals(8, numberOfGoals);
    }
    
    @Test
    public void shouldGetAllByEmployeeId() throws Exception {
        Integer employeeId = 1;
        int numberOfGoals = goalRepository.findAllByEmployeeId(employeeId).size();
        assertEquals(1, numberOfGoals);
    }
}
