package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Note;

import java.util.Optional;

public interface NoteRepositorySpringDataJdbc extends CrudRepository<Note, Integer> {
    Optional<Note> findByNoteId(Integer id);
}
