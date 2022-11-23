package uk.ac.cardiff.ASE2022Y2TEAM07.api;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.SupervisorDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.SupervisorService;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.message.ResponseTransfer;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.forms.SupervisorSignupForm;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class SupervisorRestController {
    private SupervisorService supervisorService;

    @GetMapping("supervisor")
    public ResponseEntity<List<SupervisorDto>> findAllSupervisors(@RequestParam(value="supervisorID", defaultValue = "") Integer supervisorID) {
        return ResponseEntity.ok(supervisorService.findAll());
    }

    @GetMapping("supervisor/onetoone/")
    public ResponseEntity<List<SupervisorDto>> findAllSupervisors1to1s(@RequestParam(value="supervisorID", defaultValue = "") Integer supervisorID) {
        return ResponseEntity.ok(supervisorService.findAllSupervisors1to1s(supervisorID));
    }

    @GetMapping("supervisor/checkin")
    public ResponseEntity<List<SupervisorDto>> findAllSupervisorsCheckins(@RequestParam(value="supervisorID", defaultValue = "") Integer supervisorID){
        return ResponseEntity.ok(supervisorService.findAllSupervisorsCheckins(supervisorID));
    }

    @PostMapping("supervisor")
    public ResponseTransfer createSupervisor(@RequestBody SupervisorSignupForm supervisorSignupForm) {
        //TODO: add supervisor details to database
        return new ResponseTransfer("Employee created successfully", "200");
    }

}
