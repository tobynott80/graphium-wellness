package uk.ac.cardiff.ASE2022Y2TEAM07.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Supervisor {

    public int getSupervisorId() {
        return supervisorId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    private int supervisorId;
    private String name;
    private String email;
    private String passwordHash;

}
