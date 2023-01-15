package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


/**
 * Note class. Contains the information for a note.
 */
@Data
@Table("NOTE")
public class Note {

    @Id
    @Column("NOTE_ID")
    private Integer noteId;
    private Integer OneToOneId;
    private String note;

    public Note(Integer noteID, Integer oneToOneId, String note) {
        noteId = noteID;
        OneToOneId = oneToOneId;
        this.note = note;
    }
    public Note(Integer oneToOneId, String note) {
        OneToOneId = oneToOneId;
        this.note = note;
    }

    public Note() {
    }
    public Integer getNoteId() {
        return noteId;
    }

    public Integer getOneToOneId() {
        return OneToOneId;
    }

    public String getNote() {
        return note;
    }
}
