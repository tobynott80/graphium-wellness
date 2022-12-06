package uk.ac.cardiff.ASE2022Y2TEAM07.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Checkin;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.CheckinDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.CheckinRepository;

import java.util.List;

@Service
public class CheckinServiceImpl implements CheckinService {

    @Autowired
    private CheckinRepository checkinRepository;


    @Override
    public List<CheckinDto> findAll() {
        return null;
    }

    @Override
    public void save(CheckinDto checkinDto) {
        Checkin newCheckin = new Checkin(checkinDto.getEmployeeId(), checkinDto.getCheckInsId(), checkinDto.getScore(), checkinDto.getDate());
        checkinRepository.save(newCheckin);
    }

    @Override
    public Checkin getCheckinById(Integer checkInsId) {
        Checkin checkin = checkinRepository.getCheckinById(checkInsId);
        return checkin;
    }
}
