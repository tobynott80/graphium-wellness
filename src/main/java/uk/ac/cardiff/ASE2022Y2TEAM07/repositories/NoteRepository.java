package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Note;

import java.util.List;
import java.util.Optional;

public interface NoteRepository {

    Optional<Note> getNoteById(Integer NoteId);

    void save(Note note);

    Optional<Note> getNoteByNoteId(int NoteId);
}
