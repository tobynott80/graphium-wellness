package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.AUTO;

@Data
public class Note {

    public Note(Integer noteID, Integer oneToOneID, String note) {
        NoteId = noteID;
        OneToOneID = oneToOneID;
        this.note = note;
    }
    public Note(Integer oneToOneID, String note) {
        OneToOneID = oneToOneID;
        this.note = note;
    }

    @Id
    @Column("NOTE_ID")
    @GeneratedValue(strategy = AUTO)
    private Integer NoteId;
    private Integer OneToOneID;
    private String note;


}
