package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;

public interface EmployeeRepository {

    Employee findByEmail(String email);
}
