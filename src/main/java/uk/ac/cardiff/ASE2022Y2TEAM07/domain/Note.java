package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Note {

    public Note(Integer noteID, Integer oneToOneID, String note) {
        NoteId = noteID;
        OneToOneID = oneToOneID;
        this.note = note;
    }

    @Id
    private Integer NoteId;
    private Integer OneToOneID;
    private String note;


}
