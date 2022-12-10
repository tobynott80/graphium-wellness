package uk.ac.cardiff.ASE2022Y2TEAM07.service;

import org.springframework.stereotype.Service;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Checkin;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.CheckinDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.EmployeeDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.forms.EmployeeSignupForm;

import java.util.List;
import java.util.Map;

@Service
public interface EmployeeService {
    List<EmployeeDto> findAll();

    List<OneToOneDto> findAllEmployees1to1s(Integer employeeID);

    List<CheckinDto> findAllEmployeesCheckins(Integer employeeID);

    void createEmployee(EmployeeSignupForm employeeSignupForm);

    Map<Integer,Integer> getAvg();

}
