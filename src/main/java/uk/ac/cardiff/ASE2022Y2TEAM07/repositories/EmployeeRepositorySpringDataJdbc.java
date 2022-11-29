package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;

import java.util.Optional;

public interface EmployeeRepositorySpringDataJdbc extends CrudRepository<Employee, Integer> {

    Iterable<Employee> findAll();

    Optional<Employee> findById(Integer id);

    Employee findByEmail(String email);

    Employee findByEmployeeId(String employeeId);



}
