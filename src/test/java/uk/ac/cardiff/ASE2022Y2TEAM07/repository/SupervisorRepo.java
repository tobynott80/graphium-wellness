package uk.ac.cardiff.ASE2022Y2TEAM07.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Supervisor;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.SupervisorRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SupervisorRepo {
    @Autowired
    private SupervisorRepository supervisorRepository;

    @Test
    public void shouldGetSupervisor() throws Exception {
        //GIVEN
        String email = "carl@gmail.com";
        Supervisor carl = supervisorRepository.findByEmail(email);
        assertEquals("CARL", carl.getName());
    }

    @Test
    public void shouldGetSupervisorById() throws Exception {
        //GIVEN
        Integer supervisorId = 1;
        Supervisor carl = supervisorRepository.findBySupervisorId(supervisorId);
        assertEquals("CARL", carl.getName());
    }

    @Test
    public void shouldGetAllSupervisors() throws Exception {
        //GIVEN there are 4 supervisors in the test db (H2)
        int numberOfSupervisors = supervisorRepository.findAll().size();
        assertEquals(4, numberOfSupervisors);
    }
}