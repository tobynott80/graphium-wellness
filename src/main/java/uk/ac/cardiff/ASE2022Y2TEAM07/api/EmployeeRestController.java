package uk.ac.cardiff.ASE2022Y2TEAM07.api;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.CheckinDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.EmployeeDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.EmployeeService;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.message.ResponseTransfer;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.forms.EmployeeSignupForm;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class EmployeeRestController {

    private EmployeeService employeeService;


    @GetMapping("employee")
    public ResponseEntity<List<EmployeeDto>> findAllEmployees(@RequestParam(value="employeeID", defaultValue = "") Integer employeeID) {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("employee/onetoone/")
    public ResponseEntity<List<OneToOneDto>> findAllEmployees1to1s(@RequestParam(value="employeeID", defaultValue = "") Integer employeeID) {
        return ResponseEntity.ok(employeeService.findAllEmployees1to1s(employeeID));
    }

    @GetMapping("employee/checkin")
    public ResponseEntity<List<CheckinDto>> findAllCheckins(@RequestParam(value="employeeID", defaultValue = "") Integer employeeID){
        return ResponseEntity.ok(employeeService.findAllEmployeesCheckins(employeeID));
    }

    @PostMapping("employee")
    public ResponseTransfer  createEmployee(@RequestBody EmployeeSignupForm employeeSignupForm) {
        //TODO: add employee details to database
        return new ResponseTransfer("Employee created successfully", "200");
    }
}
