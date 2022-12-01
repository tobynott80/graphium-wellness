package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Table
public class OneToOne {
    private int OneToOneId;
    private int employeeId;
    private int supervisorId;

    public OneToOne(int oneToOneId, int employeeId, int supervisorId, LocalDate date) {
        OneToOneId = oneToOneId;
        this.employeeId = employeeId;
        this.supervisorId = supervisorId;
        this.date = date;
    }

    private LocalDate date;


    public int getOneToOneId() {
        return OneToOneId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public LocalDate getDate() {
        return date;
    }


}
