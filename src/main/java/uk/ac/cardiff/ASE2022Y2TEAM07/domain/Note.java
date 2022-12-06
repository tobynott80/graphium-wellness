package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Table
public class Note {

    @Id
    @Column("NOTE_ID")
    private Integer noteId;
    private Integer OneToOneID;
    private String note;

    public Note(Integer noteID, Integer oneToOneID, String note) {
        noteId = noteID;
        OneToOneID = oneToOneID;
        this.note = note;
    }
    public Note(Integer oneToOneID, String note) {
        OneToOneID = oneToOneID;
        this.note = note;
    }

    public Note() {
    }
    public Integer getNoteId() {
        return noteId;
    }

    public Integer getOneToOneID() {
        return OneToOneID;
    }

    public String getNote() {
        return note;
    }
}
