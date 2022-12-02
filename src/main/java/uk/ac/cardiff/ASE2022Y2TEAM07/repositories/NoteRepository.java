package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Note;

import java.util.Optional;

public interface NoteRepository {

//    Optional<Note> getNoteById(Integer noteId);

    void save(Note note);
}
