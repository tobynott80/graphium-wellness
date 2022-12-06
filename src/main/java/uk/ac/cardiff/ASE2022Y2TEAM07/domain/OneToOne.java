package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Table
public class OneToOne {
    @Id
    @Column("ONE_TO_ONE_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int oneToOneId;
    private int employeeId;
    private int supervisorId;

    public OneToOne(int employeeId, int supervisorId, LocalDateTime date) {
        this.employeeId = employeeId;
        this.supervisorId = supervisorId;
        this.date = date;
    }
    public OneToOne(int oneToOneId, int employeeId, int supervisorId, LocalDateTime date) {
        this.oneToOneId = oneToOneId;
        this.employeeId = employeeId;
        this.supervisorId = supervisorId;
        this.date = date;
    }

    public OneToOne(int oneToOneId, int employeeId, int supervisorId, Date date) {
        this.oneToOneId = oneToOneId;
        this.employeeId = employeeId;
        this.supervisorId = supervisorId;
        this.date = date.toLocalDate().atStartOfDay();
    }

    public OneToOne() {
    }

    private LocalDateTime date;


    public int getOneToOneId() {
        return oneToOneId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public LocalDateTime getDate() {
        return date;
    }


}
