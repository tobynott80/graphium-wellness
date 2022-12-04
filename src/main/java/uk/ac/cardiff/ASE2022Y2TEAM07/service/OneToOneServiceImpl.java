package uk.ac.cardiff.ASE2022Y2TEAM07.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Note;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.NoteDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.NoteRepository;

import uk.ac.cardiff.ASE2022Y2TEAM07.assembler.OneToOneAssembler;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.OneToOneRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.message.OneToOneListRequest;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.message.OneToOneListResponse;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OneToOneServiceImpl implements OneToOneService {


    @Autowired
    private OneToOneRepository oneToOneRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public void save(OneToOneDto oneToOneDto, NoteDto noteDto) {
        System.out.println("Coming from service: " + oneToOneDto.toString());
        OneToOne newOneToOne = new OneToOne(oneToOneDto.getEmployeeId(), oneToOneDto.getSupervisorId(), oneToOneDto.getDate());
        oneToOneRepository.save(newOneToOne);
        Integer newOneToOneId = oneToOneRepository.getNewestOneToOneId();
        Note newNote = new Note(newOneToOneId, noteDto.getNote());

        noteRepository.save(newNote);

    }

    @Override
    public List<OneToOneDto> findAll() {
        return null;
    }

    @Override
    public OneToOne getOneToOneById(Integer OneToOneId) {
        OneToOne oneToOne = oneToOneRepository.getOneToOneById(OneToOneId);
        return oneToOne;
    }

    private List<Object> getOneToOnes() {
        List<OneToOne> onetoones = OneToOneRepository.getOneToOnes();
        return onetoones.stream().map(c -> OneToOneAssembler.toDto(c)).collect(Collectors.toList());

    }

    public OneToOneListResponse getAllOneToOne(OneToOneListRequest onetooneListRequest) {
        return null;

//    //working on this
//
//    private final OneToOneRepository oneToOneRepository;
    }

    public OneToOneServiceImpl(OneToOneRepository otoRepo) {
            this.oneToOneRepository = otoRepo;
    }

    public OneToOneListResponse getOneToOnes (OneToOneListRequest oneToOneListRequest){
        List<OneToOneDto> oneToOnes;
        if (oneToOneListRequest.hasSearchTerm()) {
            oneToOnes = getOneToOnesBySearch(OneToOneListRequest.getSearchTerm());
        } else {
            oneToOnes = getOneToOnes(listRequest);
        }

        return OneToOneListResponse
                .of()
                .request(oneToOneListRequest)
                .onetoone(oneToOnes)
                .build();
    }

    private List<OneToOneDto> getOneToOnes () {
        
    }

    private List<OneToOneDto> getOneToOnes(OneToOneListRequest listRequest) {
        List<OneToOne> oneToOnes = oneToOneRepository.getOneToOnes();

        return oneToOnes.stream().map(oto -> OneToOneAssembler.toDto(oto)).collect(Collectors.toList());
    }

}
