package uk.ac.cardiff.ASE2022Y2TEAM07.web.mock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.OneToOneService;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.message.OneToOneListRequest;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.message.OneToOneListResponse;
//import uk.ac.cardiff.ASE2022Y2TEAM07.web.controller.OneToOneController;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.controller.SupervisorOneToOneController;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SupervisorOneToOneController.class)
@AutoConfigureMockMvc
public class GetOneToOnes {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    OneToOneService oneToOneService;

    @Test
    public void shouldGet3OneToOnes() throws Exception {

        OneToOneDto oto1 = new OneToOneDto(1,1,1, LocalDate.parse("2022-12-12"));
        OneToOneDto oto2 = new OneToOneDto(2,2,1,LocalDate.parse("2022-12-13"));
        OneToOneDto oto3 = new OneToOneDto(3,3,1,LocalDate.parse("2022-12-13"));

        OneToOneListRequest oneToOneListRequest = OneToOneListRequest
                .of()
                .build();

        OneToOneListResponse oneToOneListResponse = OneToOneListResponse
                .of()
                .request(oneToOneListRequest)
                .oneToOnes(List.of(oto1,oto2,oto3))
                .build();

        given(oneToOneService.getOneToOnes(oneToOneListRequest)).willReturn(oneToOneListResponse);


//        String HTMLFragment = """
//                <a href="/charity/profile/a">A</a>""";
//
//        MvcResult result = mvc
//                .perform(get("/charity/charity-list"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn();
//
//        String content = result.getResponse().getContentAsString();
//
//        assertTrue(content.contains(HTMLFragment));
    }
}
