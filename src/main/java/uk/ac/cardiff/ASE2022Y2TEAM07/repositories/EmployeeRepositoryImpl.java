package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Checkin;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;

import java.util.ArrayList;
import java.util.List;


@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private EmployeeRepositorySpringDataJdbc repoJdbc;
    private JdbcTemplate jdbc;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public EmployeeRepositoryImpl(EmployeeRepositorySpringDataJdbc aRepo, JdbcTemplate jdbcTemplate) {
        repoJdbc = aRepo;
        jdbc = jdbcTemplate;
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
