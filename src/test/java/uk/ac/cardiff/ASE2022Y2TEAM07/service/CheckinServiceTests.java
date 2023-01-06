package uk.ac.cardiff.ASE2022Y2TEAM07.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.CheckinDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.EmployeeRepository;


import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Profile("dev")
public class CheckinServiceTests {

    @Autowired
    private CheckinService checkinService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void shouldSaveCheckin() {

        Date now = Date.valueOf(LocalDate.now());
        //Given
        CheckinDto checkinDto = new CheckinDto(3, 3, 8, now);
        //When
        checkinService.save(checkinDto);
        //Then
        assertEquals("OLI", employeeRepository.findByEmployeeId(checkinService.getCheckinById(3).getEmployeeId()).getName());
    }
}

