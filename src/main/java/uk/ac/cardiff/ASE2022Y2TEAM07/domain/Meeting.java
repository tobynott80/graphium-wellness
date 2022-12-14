package uk.ac.cardiff.ASE2022Y2TEAM07.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
public class Meeting {

    private String employeeName;
    private LocalDate date;

    public Meeting(String employeeName, LocalDate date) {
        this.employeeName = employeeName;
        this.date = date;
    }

}
