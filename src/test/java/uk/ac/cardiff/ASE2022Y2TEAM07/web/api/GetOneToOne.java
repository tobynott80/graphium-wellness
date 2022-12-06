package uk.ac.cardiff.ASE2022Y2TEAM07.web.api;

import org.junit.jupiter.api.Test;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.OneToOneRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.OneToOneRepositoryImpl;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.OneToOneService;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.OneToOneServiceImpl;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.message.OneToOneListRequest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class GetOneToOne {

    private OneToOneService oneToOneService;
    private OneToOneRepository oneToOneRepository;

    @Test
    public void shouldGetThreeOneToOnes() throws Exception {
        //GIVEN
        OneToOne oto1 = new OneToOne(1,1,1,LocalDate.parse("2022-12-12"));
        OneToOne oto2 = new OneToOne(2,2,1,LocalDate.parse("2022-12-13"));
        OneToOne oto3 = new OneToOne(3,3,1,LocalDate.parse("2022-12-13"));

        oneToOneRepository = mock(OneToOneRepositoryImpl.class);

        given(oneToOneRepository.getOneToOnes()).willReturn(List.of(oto1,oto2,oto3));

        oneToOneService = new OneToOneServiceImpl(oneToOneRepository);

        List<OneToOneDto> oneToOnes;

        OneToOneListRequest oneToOneListRequest = OneToOneListRequest
                .of()
                .build();

        //WHEN
        var oneToOneListResponse = oneToOneService.getOneToOnes(oneToOneListRequest);

        //THEN
        assertEquals(3,oneToOneListResponse.getOneToOnes().size());
    }

}
