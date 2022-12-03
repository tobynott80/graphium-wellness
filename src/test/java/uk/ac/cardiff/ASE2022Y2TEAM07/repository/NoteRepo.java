package uk.ac.cardiff.ASE2022Y2TEAM07.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Note;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.NoteRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class NoteRepo {
    @Autowired
    private NoteRepository noteRepository;

//    @Test
//    public void shouldGetNote() throws Exception {
//        //GIVEN
//        Integer noteId = 1;
//        String note = noteRepository.findByNoteId(noteId).getNote();
//        assertEquals("This is a note", note);
//    }

    @Test
    public void shouldSaveNote() throws Exception {
        //GIVEN

        noteRepository.save(new Note(1, "This is a note"));
        assertEquals("This is a note", noteRepository.getNoteByNoteId(1).get().getNote());
    }
}
