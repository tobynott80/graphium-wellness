package uk.ac.cardiff.ASE2022Y2TEAM07.service;


import org.springframework.stereotype.Service;
import uk.ac.cardiff.ASE2022Y2TEAM07.assembler.OneToOneAssembler;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.OneToOneRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OneToOneServiceImpl implements OneToOneService {
    //TODO: Implement this service

    @Override
    public List<OneToOneDto> findAll() {
        return null;
    }

//    private List<Object> getOneToOnes() {
//        List<OneToOne> onetoones = OneToOneRepository.getOneToOnes();
//        return onetoones.stream().map(c -> OneToOneAssembler.toDto(c)).collect(Collectors.toList());
//    }

}
