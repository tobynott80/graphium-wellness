package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import org.springframework.stereotype.Repository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;

import java.util.ArrayList;
import java.util.List;


@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private EmployeeRepositorySpringDataJdbc repoJdbc;

    public EmployeeRepositoryImpl(EmployeeRepositorySpringDataJdbc aRepo) {
        repoJdbc = aRepo;
    }

    @Override
    public Employee findByEmail(String email) {
        return repoJdbc.findByEmail(email);
    }

    @Override
    public Employee findByEmployeeId(Integer employeeId) {
        return repoJdbc.findByEmployeeId(employeeId);
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        repoJdbc.findAll().forEach(employees::add);
        return employees;
    }
}
