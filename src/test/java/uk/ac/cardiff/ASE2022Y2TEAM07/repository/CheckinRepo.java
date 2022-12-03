package uk.ac.cardiff.ASE2022Y2TEAM07.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Checkin;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.CheckinRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CheckinRepo {

    @Autowired
    private CheckinRepository checkinRepository;

    @Test
    public void shouldGetCheckin() throws Exception {
        //Given
        Integer score = 7;
        Checkin checkinId1 = checkinRepository.findByScore(score);
        assertEquals(1, checkinId1.getCheckInsId());
    }

    @Test
    public void shouldGetCheckinById() throws Exception {
        //Given
        Integer checkinsId = 4;
        Checkin employeeId2 = checkinRepository.findByCheckInId(checkinsId);
        assertEquals(2, employeeId2.getEmployeeId());
    }

    @Test
    public void shouldGetAllCheckins() throws Exception {
        //Given there is 8 checkins in the H2 database
        int numberOfCheckins = checkinRepository.findAll().size();
        assertEquals(8, numberOfCheckins);
    }

//    @Test
//    public void shouldGetEmployeeId() throws Exception {
//        //Given
//        Integer employeeId = 4;
//        Checkin checkinId7and8 = checkinRepository.findByEmployeeId(employeeId);
//        assertEquals(7, checkinId7and8.getEmployeeId());
//        assertEquals(8, checkinId7and8.getEmployeeId());
//    }

}
