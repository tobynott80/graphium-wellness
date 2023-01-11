package uk.ac.cardiff.ASE2022Y2TEAM07.web.mock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Checkin;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Supervisor;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.CheckinRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.EmployeeRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.SupervisorRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.CheckinService;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.CheckinServiceImpl;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.*;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.controller.SupervisorOneToOneController;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SupervisorCheckinController.class)
@AutoConfigureMockMvc
public class SecurityTests {
    @Autowired
    MockMvc mvc;

    @MockBean
    CheckinServiceImpl checkinService;

    @MockBean
    EmployeeRepository employeeRepository;

    @MockBean
    SupervisorRepository supervisorRepository;

    @WithMockUser(value = "carl@gmail.com")
    @Test
    public void shouldAllowSupervisorToAccessSupervisorPage() throws Exception {
        Supervisor mockSupervisor = new Supervisor(1, "Carl", "carl@gmail.com", "1");
        doReturn(mockSupervisor).when(supervisorRepository).findByEmail("carl@gmail.com");

        Map<Integer, Integer> mockAvg = Map.of(1, 2);
        doReturn(mockAvg).when(checkinService).getAvg();

        Set<Checkin> mockCheckins = new HashSet<>();
        Employee mockEmployee = new Employee(1, "Johnny", "johnny@gmail.com", "password", "1", 1, mockCheckins);
        doReturn(mockEmployee).when(employeeRepository).findByEmployeeId(1);

        MvcResult result = mvc.perform(get("/supervisor"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String expectedHTMLContent = """
                <h2>Scheduled One To One meetings</h2>""";
        String content = result.getResponse().getContentAsString();
        assertTrue(content.contains(expectedHTMLContent));
    }

    @WithMockUser(username = "john@gmail.com")
    @Test
    public void shouldDenyEmployeeToAccessSupervisorPage() throws Exception {


        MvcResult result = mvc.perform(get("/supervisor"))
                .andDo(print())
                .andExpect(redirectedUrl("/403"))
                .andReturn();

    }


}
