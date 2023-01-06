package uk.ac.cardiff.ASE2022Y2TEAM07.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.EmployeeRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Profile("dev")
public class EmployeeRepo {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void shouldGetEmployee() throws Exception {
        //GIVEN
        String email = "JOHN@GMAIL.COM";
        Employee john = employeeRepository.findByEmail(email);
        assertEquals("JOHN", john.getName());
    }

    @Test
    public void shouldGetEmployeeById() throws Exception {
        //GIVEN
        Integer employeeId = 1;
        Employee john = employeeRepository.findByEmployeeId(employeeId);
        assertEquals("JOHN", john.getName());
    }

    @Test
    public void shouldGetAllEmployees() throws Exception {
        //GIVEN there are 8 employees in the test db (H2)
        int numberOfEmployees = employeeRepository.findAll().size();
        assertEquals(8, numberOfEmployees);
    }
}
