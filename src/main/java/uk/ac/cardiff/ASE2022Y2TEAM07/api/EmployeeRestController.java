package uk.ac.cardiff.ASE2022Y2TEAM07.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.EmployeeDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.EmployeeService;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.OneToOneService;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    private OneToOneService onetoOneService;

    public EmployeeRestController(EmployeeService employeeService, OneToOneService onetoOneService) {
        this.employeeService = employeeService;
        this.onetoOneService = onetoOneService;
    }


    @GetMapping("employee")
    public ResponseEntity<List<EmployeeDto>> findAllEmployees() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("1to1")
    public ResponseEntity<List<OneToOneDto>> findAll1to1s() {
        return ResponseEntity.ok(onetoOneService.findAll());
    }
}
