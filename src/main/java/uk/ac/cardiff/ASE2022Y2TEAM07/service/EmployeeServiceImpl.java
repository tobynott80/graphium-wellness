package uk.ac.cardiff.ASE2022Y2TEAM07.service;


import org.springframework.stereotype.Service;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.CheckinDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.EmployeeDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    //here the findAll method will be implemented when the database is complete

    private final EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDto> findAll() {
        return null;
    }

    @Override
    public List<OneToOneDto> findAllEmployees1to1s(Integer employeeID) {
        return null;
    }

    @Override
    public List<CheckinDto> findAllEmployeesCheckins(Integer employeeID) {
        return null;
    }
}
