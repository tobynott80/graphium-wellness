package uk.ac.cardiff.ASE2022Y2TEAM07.service;


import org.springframework.stereotype.Service;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.CheckinDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.EmployeeDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.forms.EmployeeSignupForm;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    //TODO: implement findAll method
    @Override
    public List<EmployeeDto> findAll() {
        return null;
    }

    //TODO: implement findAllEmployees1to1s method
    @Override
    public List<OneToOneDto> findAllEmployees1to1s(Integer employeeID) {
        return null;
    }

    //TODO: implement findAllEmployeesCheckins method
    @Override
    public List<CheckinDto> findAllEmployeesCheckins(Integer employeeID) {
        return null;
    }

    //TODO: implement createEmployee method
    @Override
    public void createEmployee(EmployeeSignupForm employeeSignupForm) {

    }
    //here the findAll method will be implemented when the database is complete

    //TODO: implement updateEmployee method


}
