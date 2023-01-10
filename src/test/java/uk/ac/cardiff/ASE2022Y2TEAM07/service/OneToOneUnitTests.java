package uk.ac.cardiff.ASE2022Y2TEAM07.service;

import org.junit.jupiter.api.Test;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.NoteDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.OneToOneRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.OneToOneRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class OneToOneUnitTests {

    private OneToOneService oneToOneService;

    private OneToOneRepository oneToOneRepository;

    @Test
    public void shouldGetFourOneToOnesFromRepo() throws Exception {
        OneToOne o1 = new OneToOne(1, 1, LocalDate.now());
        OneToOne o2 = new OneToOne(2, 2, LocalDate.now());
        OneToOne o3 = new OneToOne(3, 3, LocalDate.now());
        OneToOne o4 = new OneToOne(4, 4, LocalDate.now());

        oneToOneRepository = mock(OneToOneRepositoryImpl.class);
        given(oneToOneRepository.findAll()).willReturn(List.of(o1, o2, o3, o4));

        System.out.println(oneToOneRepository.findAll());
        assertEquals(4, oneToOneRepository.findAll().size());
    }


}
