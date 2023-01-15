package uk.ac.cardiff.ASE2022Y2TEAM07.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Note;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.NoteRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Profile("dev")
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
    public void shouldGetNote() throws Exception {
        //GIVEN there is a note with "good well-being" in the test db (H2)
        //WHEN the note is retrieved
        //THEN the note text is "good well-being"
        assertEquals("good well-being", noteRepository.getNoteByNoteId(1).get().getNote());
    }

    @Test
    public void shouldSaveNote() throws Exception {
        //GIVEN a new note is saved
        Integer oldNotes = noteRepository.findAll().size();
        Note note = new Note(3, "This is a note");
        noteRepository.save(note);
        //WHEN the size of the notes db is retrieved and there are 4 original notes in the db
        assertEquals(oldNotes + 1 , noteRepository.findAll().size());
        //THEN there should be 5 notes in the db
    }
}
