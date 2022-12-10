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

    @Autowired
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
    public Employee findByName(String name) {
        return repoJdbc.findByName(name);
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        repoJdbc.findAll().forEach(employees::add);
        return employees;
    }

    @Override
    public List<Checkin> findEmployeeWithAvg() {
        RowMapper<Checkin> checkinMapper = (rs, i) -> new Checkin();
        String employeeAvg = "SELECT AVG(CHECK_INS.SCORE), CHECK_INS.EMPLOYEE_ID FROM CHECK_INS JOIN EMPLOYEE ON EMPLOYEE.EMPLOYEE_ID = CHECK_INS.EMPLOYEE_ID GROUP BY CHECK_INS.EMPLOYEE_ID";
        return jdbc.query(employeeAvg, checkinMapper);
    }
}
