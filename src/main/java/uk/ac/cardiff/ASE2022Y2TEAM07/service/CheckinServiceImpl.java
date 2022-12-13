package uk.ac.cardiff.ASE2022Y2TEAM07.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Checkin;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.CheckinDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.CheckinRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Checkin newCheckin = new Checkin(checkinDto.getCheckInsId(), checkinDto.getEmployeeId(), checkinDto.getScore(), checkinDto.getDate());
        checkinRepository.save(newCheckin);
    }

    @Override
    public Checkin getCheckinById(Integer checkInsId) {
        Checkin checkin = checkinRepository.getCheckinById(checkInsId);
        return checkin;
    }

    public Map<Integer,Integer> getAvg(){
        List<Checkin> checkins = checkinRepository.findEmployeeWithAvg();
        Map<Integer,Integer> employeeWithAvg = new HashMap<>();
        for (Checkin c : checkins) {
            employeeWithAvg.put(c.getEmployeeId(),c.getScore());
        }
        return employeeWithAvg;
    }

    public Integer getAvgByEmployeeId(Integer employeeId){
        List<Checkin> checkins = checkinRepository.findEmployeeWithAvg();
        for (Checkin c : checkins) {
            System.out.println("Employee ID: " + c.getEmployeeId() + " Average Score: " + c.getScore());
            if (c.getEmployeeId().equals(employeeId)) return c.getScore();
        }
        return 0;
    }
}
