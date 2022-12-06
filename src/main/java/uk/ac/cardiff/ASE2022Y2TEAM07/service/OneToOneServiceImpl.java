package uk.ac.cardiff.ASE2022Y2TEAM07.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Note;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.NoteDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.NoteRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.OneToOneRepository;

import java.util.List;


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
        Note newNote = new Note(newOneToOneId,noteDto.getNote());

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


}
