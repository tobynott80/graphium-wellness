package uk.ac.cardiff.ASE2022Y2TEAM07.web.mock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.CheckinRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.EmployeeRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.CheckinServiceImpl;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.SupervisorCheckinController;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SupervisorCheckinController.class)
@AutoConfigureMockMvc(addFilters = false)
public class GetCheckinsAsSupervisor {

    @MockBean
    private EmployeeRepository employeeRepository;

    @MockBean
    private CheckinRepository checkinRepository;

    @MockBean
    private CheckinServiceImpl checkinService;

    @Autowired
    MockMvc mvc;

    @Test
    public void shouldListAverage() throws Exception {

        MvcResult result = mvc.perform(get("/supervisor"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String expectedHTMLContent = """
                <th scope="col">Employee Average</th>""";

        String content = result.getResponse().getContentAsString();

        assertTrue(content.contains(expectedHTMLContent));

    }
}
