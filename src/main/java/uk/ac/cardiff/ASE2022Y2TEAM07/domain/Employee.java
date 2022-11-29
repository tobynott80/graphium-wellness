package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table("EMPLOYEE")
public class Employee {
    @Id
    private Integer employeeId;
    private String name;
    private String email;
    private String role;
    private String passwordHash;
    private Integer supervisorId;
}
