package uk.ac.cardiff.ASE2022Y2TEAM07.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.EmployeeRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EmployeeRepo {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void shouldGetEmployee() throws Exception {
        //GIVEN
        String email = "JOHN@GMAIL.COM";
        Employee john = employeeRepository.findByEmail(email);
        assertEquals("John", john.getName());
    }
}
