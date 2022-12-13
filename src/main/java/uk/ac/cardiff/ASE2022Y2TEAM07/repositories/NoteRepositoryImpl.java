package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;


import org.springframework.stereotype.Repository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Note;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class NoteRepositoryImpl implements NoteRepository {
    private NoteRepositorySpringDataJdbc repoJdbc;

    public NoteRepositoryImpl(NoteRepositorySpringDataJdbc aRepo) {
        repoJdbc = aRepo;
    }

//    @Override
//    public Optional<Note> getNoteById(Integer noteId) {
//        Optional<Note> note = repoJdbc.findByNoteId(noteId);
//        return note;
//    }

    @Override
    public Optional<Note> getNoteById(Integer NoteId) {
        return repoJdbc.findById(NoteId);
    }

    @Override
    public void save(Note note) {
        repoJdbc.save(note);
    }

    @Override
    public Optional<Note> getNoteByNoteId(int NoteId) {
        return repoJdbc.findByNoteId(NoteId);
    }

    @Override
    public List<Note> findAll() {
        List<Note> notes = new ArrayList<>();
        repoJdbc.findAll().forEach(notes::add);
        return notes;
    }

}
