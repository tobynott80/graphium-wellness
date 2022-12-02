package uk.ac.cardiff.ASE2022Y2TEAM07.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class EmployeeDto {
    private Integer employeeId;
    private String name;
    private String email;
    private String role;
    private String passwordHash;
    private Integer supervisorId;
}
