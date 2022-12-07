package uk.ac.cardiff.ASE2022Y2TEAM07.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.cardiff.ASE2022Y2TEAM07.assembler.OneToOneAssembler;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.OneToOneRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.message.OneToOneListRequest;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.message.OneToOneListResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OneToOneServiceImpl implements OneToOneService {

    //TODO: Implement this service

    //working on this
    private final OneToOneRepository oneToOneRepository;

    public OneToOneServiceImpl(OneToOneRepository otoRepo) {
        this.oneToOneRepository = otoRepo;
    }

//    @Override
//    public List<OneToOneDto> findAll() {
//        List<OneToOne> oneToOnes = oneToOneRepository.findAll();
//        return OneToOneAssembler.toDto(oneToOnes);
//    }

    @Override
    public List<OneToOneDto> getSupervisorOneToOnes() {
        List<OneToOne> oneToOnes = oneToOneRepository.getOneToOnes();

        return OneToOneAssembler.toDto(oneToOnes);
    }


    @Override
    public List<OneToOneDto> findAll() {
        List<OneToOne> oneToOnes = oneToOneRepository.getOneToOnes();
        return OneToOneAssembler.toDto(oneToOnes);
    }

    @Override
    public OneToOneListResponse getOneToOnes(OneToOneListRequest oneToOneListRequest) {
        List<OneToOneDto> oneToOnes;
        if (oneToOneListRequest.hasSearchTerm()) {
            oneToOnes= getOneToOnesBySearch(oneToOneListRequest.getSearchTerm());
        } else {
            oneToOnes = getOneToOnes();
        }

        return OneToOneListResponse
                .of()
                .request(oneToOneListRequest)
                .oneToOnes(oneToOnes)
                .build();
    }

    private List<OneToOneDto> getOneToOnesBySearch(Integer search) {
        List<OneToOne> oneToOnes = oneToOneRepository.getOneToOnesBySearch(search);
        return oneToOnes.stream().map(oto -> OneToOneAssembler.toDto(oto)).collect(Collectors.toList());
    }

    private List<OneToOneDto> getOneToOnes() {
        List<OneToOne> oneToOnes = oneToOneRepository.getOneToOnes();
        return oneToOnes.stream().map(oto -> OneToOneAssembler.toDto(oto)).collect(Collectors.toList());
    }

//    public List<Charity> getCharities() {
//
//        String allCharitiesSQL = "select * from charity";
//        return jdbc.query(allCharitiesSQL, charityMapper);
//
//    }
//
}
