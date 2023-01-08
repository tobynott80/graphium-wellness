package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Checkin;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;

import java.util.List;
import java.util.Map;

/**
 * Employee repository interface. Contains the methods for accessing the employee table in the database.
 */
public interface EmployeeRepository {

    Employee findByEmail(String email);

    Employee findByEmployeeId(Integer employeeId);

    List<Employee> findAll();
}
