package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;

@Data
@Table
public class OneToOne {
    @Id
    @Column("ONE_TO_ONE_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int oneToOneId;
    private int employeeId;
    private int supervisorId;

    public OneToOne(int employeeId, int supervisorId, LocalDate date) {
        this.employeeId = employeeId;
        this.supervisorId = supervisorId;
        this.date = date;
    }
    public OneToOne(int oneToOneId, int employeeId, int supervisorId, LocalDate date) {
        this.oneToOneId = oneToOneId;
        this.employeeId = employeeId;
        this.supervisorId = supervisorId;
        this.date = date;
    }

    public OneToOne() {
    }

    private LocalDate date;


    public int getOneToOneId() {
        return oneToOneId;
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
