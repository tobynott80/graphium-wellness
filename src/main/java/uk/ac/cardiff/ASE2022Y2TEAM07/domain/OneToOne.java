package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table
public class OneToOne {
    @Id
    @Column("ONE_TO_ONE_ID")
    private int oneToOneId;
    private int employeeId;
    private int supervisorId;

    private LocalDate date;


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

    //Constructor for taking in SQL date format and converting to javaLocalDate
    public OneToOne(int oneToOneId, int employeeId, int supervisorId, Date date) {
        this.oneToOneId = oneToOneId;
        this.employeeId = employeeId;
        this.supervisorId = supervisorId;
        this.date = date.toLocalDate();
    }

    public OneToOne() {
    }



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



    private Integer One_To_One_ID;
    private Integer Employee_ID;
    private Integer Supervisor_ID;
    private String Date;

}
