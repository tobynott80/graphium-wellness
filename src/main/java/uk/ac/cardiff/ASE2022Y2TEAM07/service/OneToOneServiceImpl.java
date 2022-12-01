package uk.ac.cardiff.ASE2022Y2TEAM07.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Note;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.NoteDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.OneToOneRepository;

import java.util.List;


@Service
public class OneToOneServiceImpl implements OneToOneService {

    @Autowired
    private OneToOneRepository oneToOneRepository;

    @Override
    public void save(OneToOneDto oneToOneDto, NoteDto noteDto) {
        System.out.println("Coming from service: " + oneToOneDto.toString());
        OneToOne newOneToOne = new OneToOne(oneToOneDto.getOneToOneId(), oneToOneDto.getEmployeeId(), oneToOneDto.getSupervisorId(), oneToOneDto.getDate());
        Note newNote = new Note(noteDto.getNoteID(),
                noteDto.getOneToOneID(),
                noteDto.getNote());
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
