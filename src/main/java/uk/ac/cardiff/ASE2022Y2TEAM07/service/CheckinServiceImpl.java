package uk.ac.cardiff.ASE2022Y2TEAM07.service;

import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Checkin;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.CheckinDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.CheckinRepositoryImpl;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.CheckinRepositorySpringDataJdbc;

import java.util.ArrayList;
import java.util.List;

public class CheckinServiceImpl implements CheckinService {

    private CheckinRepositorySpringDataJdbc repoJdbc;

    private final CheckinRepositoryImpl checkinRepository;

    public CheckinServiceImpl(CheckinRepositoryImpl checkinRepository) {
        this.checkinRepository = checkinRepository;
    }


    @Override
    public List<CheckinDto> findAll() {
        System.out.println("service123");
        List<CheckinDto> checkins = new ArrayList<>();
//        repoJdbc.findAll().forEach(checkins::add);
//        return checkins;
        return checkins;
    }

    @Override
    public void save(Checkin checkin) {
        checkinRepository.save(checkin);
    }
}
