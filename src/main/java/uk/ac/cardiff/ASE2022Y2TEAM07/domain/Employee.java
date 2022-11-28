package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private int employeeId;
    private String name;
    private String email;
    private String role;
    private String passwordHash;
    private int supervisorId;
}
