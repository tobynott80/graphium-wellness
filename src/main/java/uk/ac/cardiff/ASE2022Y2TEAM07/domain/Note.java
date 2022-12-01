package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Note {

    public Note(Integer noteID, Integer oneToOneID, String note) {
        NoteID = noteID;
        OneToOneID = oneToOneID;
        this.note = note;
    }
    private Integer NoteID;
    private Integer OneToOneID;
    private String note;


}
