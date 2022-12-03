package uk.ac.cardiff.ASE2022Y2TEAM07.dto;


import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.data.annotation.Id;

@Value
public class NoteDto {
    public NoteDto(Integer noteID, Integer oneToOneID, String note) {
        NoteID = noteID;
        OneToOneID = oneToOneID;
        this.note = note;
    }


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
