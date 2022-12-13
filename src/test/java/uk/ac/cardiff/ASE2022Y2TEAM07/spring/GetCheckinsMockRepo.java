package uk.ac.cardiff.ASE2022Y2TEAM07.spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Checkin;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.CheckinRepository;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GetCheckinsMockRepo {

    @MockBean
    private CheckinRepository checkinRepository;

    @Test
    public void shouldGetFourCheckins() throws Exception {

        Date now = Date.valueOf(LocalDate.now());

        //Given
        Checkin c1 = new Checkin(1,1,10, now);
        Checkin c2 = new Checkin(2,2,10, now);
        Checkin c3 = new Checkin(3,3,10, now);
        Checkin c4 = new Checkin(4,4,10, now);

        //When
        checkinRepository.save(c1);
        checkinRepository.save(c2);
        checkinRepository.save(c3);
        checkinRepository.save(c4);

        //Then
        assertEquals(4, checkinRepository.findAll().size());
    }

    @Test
    public void shouldGetCheckinScoreTen() throws Exception {

        Date now = Date.valueOf(LocalDate.now());

        //Given
        Checkin c1 = new Checkin(1,1,10, now);

        //When
        checkinRepository.save(c1);

        //Then
        assertEquals(10, checkinRepository.findByScore(10));
    }

    @Test
    public void shouldGetCheckinIdOne() throws Exception {

        Date now = Date.valueOf(LocalDate.now());

        //Given
        Checkin c1 = new Checkin(1,1,10, now);

        //When
        checkinRepository.save(c1);

        //Then
        assertEquals(1, checkinRepository.findByCheckInId(1));
    }
}










