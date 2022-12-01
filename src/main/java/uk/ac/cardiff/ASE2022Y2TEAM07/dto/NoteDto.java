package uk.ac.cardiff.ASE2022Y2TEAM07.dto;


import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class NoteDto {
    public Integer getNoteID() {
        return NoteID;
    }

    public Integer getOneToOneID() {
        return OneToOneID;
    }

    public String getNote() {
        return note;
    }

    private Integer NoteID;
    private Integer OneToOneID;
    private String note;
}
