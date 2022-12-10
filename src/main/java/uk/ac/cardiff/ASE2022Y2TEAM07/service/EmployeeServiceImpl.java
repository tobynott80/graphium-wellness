package uk.ac.cardiff.ASE2022Y2TEAM07.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Checkin;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.EmployeeRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl {
    //here the findAll method will be implemented when the database is complete

    @Autowired
    private EmployeeRepository employeeRepository;

    public Map<Integer,Integer> getAvg(){
        System.out.println(employeeRepository.findEmployeeWithAvg());
        List<Checkin> checkins = employeeRepository.findEmployeeWithAvg();
        Map<Integer,Integer> employeeWithAvg = new HashMap<>();
        for (Checkin c : checkins) {
            employeeWithAvg.put(c.getEmployeeId(),c.getScore());
        }
        return employeeWithAvg;
    }
}
