package uk.ac.cardiff.ASE2022Y2TEAM07.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.CheckinDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.CheckinRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CheckinServiceTests {

    @Autowired
    private CheckinService checkinService;

    @Autowired
    private CheckinRepository checkinRepository;

    //TODO: implement the methods to make this test work.
//    @Test
//    public void shouldSaveCheckin() {
//        //Given
//        CheckinDto checkinDto = new CheckinDto(3, 1, 8, LocalDate.now());
//        //When
//        checkinService.save(checkinDto);
//        //Then
//        assertEquals(3, checkinRepository.findByCheckInId(3));
//    }
}

