package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import org.springframework.stereotype.Repository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Checkin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CheckinRepositoryImpl implements CheckinRepository{

    private CheckinRepositorySpringDataJdbc repoJdbc;

    public CheckinRepositoryImpl(CheckinRepositorySpringDataJdbc aRepo){
        this.repoJdbc = aRepo;
    }

    @Override
    public Checkin findByCheckInId(Integer checkinsId) {
        return repoJdbc.findByCheckInsId(checkinsId);
    }

    @Override
    public Checkin findByEmployeeId(Integer employeeId) {
        return repoJdbc.findByEmployeeId(employeeId);
    }

    @Override
    public Checkin findByScore(Integer score) {
        return repoJdbc.findByScore(score);
    }

    @Override
    public List<Checkin> findAll() {
        List<Checkin> checkins = new ArrayList<>();
        repoJdbc.findAll().forEach(checkins::add);
        return checkins;
    }

    @Override
    public void save(Checkin checkin) {
        repoJdbc.save(checkin);
    }
}
