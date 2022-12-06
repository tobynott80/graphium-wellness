package uk.ac.cardiff.ASE2022Y2TEAM07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@AllArgsConstructor
@Table
public class Employee {
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public Set<Checkin> getCheckins() {
        return checkins;
    }

    private int employeeId;
    private String name;
    private String email;
    private String role;
    private String passwordHash;
    private int supervisorId;

    @OneToMany(mappedBy = "employeeId", cascade = CascadeType.ALL)
    private Set<Checkin> checkins;


}
