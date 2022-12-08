package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;

import java.util.List;

public interface EmployeeRepository {

    Employee findByEmail(String email);

    Employee findByEmployeeId(Integer employeeId);

    Employee findByName(String name);

    List<Employee> findAll();
}
