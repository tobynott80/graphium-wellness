package uk.ac.cardiff.ASE2022Y2TEAM07.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.NoteDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.EmployeeRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.NoteRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.OneToOneRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Profile("dev")
public class OneToOneServices {

    @Autowired
    private OneToOneService oneToOneService;

    @Autowired
    private OneToOneRepository oneToOneRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private EmployeeRepository employeeRepository;




    @Test
    public void shouldSaveOneToOneAndNote() {
        //GIVEN
        OneToOneDto oneToOneDto = new OneToOneDto( 1, 1, LocalDate.now());
        NoteDto noteDto = new NoteDto(null, 5, "This is a note");

        //WHEN
        oneToOneService.save(oneToOneDto, noteDto);
        //THEN
        //Actual =  JOHN - the name of employee with id 1
        //Expected = the
        assertEquals("JOHN", employeeRepository.findByEmployeeId(oneToOneService.getOneToOneById(oneToOneRepository.findAll().size()).getEmployeeId()).getName());
    }

    @Test
    public void shouldSaveOneToOneAndNoteDetails(){
        //GIVEN
        OneToOneDto oneToOneDto = new OneToOneDto(0, 1, 1, LocalDate.now());
        NoteDto noteDto = new NoteDto(null, 5, "This is a note");
        //WHEN
        oneToOneService.save(oneToOneDto, noteDto);
        //THEN
        assertEquals("This is a note", noteRepository.getNoteById(5).get().getNote());
    }

}
