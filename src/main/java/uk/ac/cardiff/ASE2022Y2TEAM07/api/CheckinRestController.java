package uk.ac.cardiff.ASE2022Y2TEAM07.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Checkin;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.CheckinDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.CheckinRepositoryImpl;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.CheckinService;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.message.ResponseTransfer;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.forms.CheckinForm;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api")
public class CheckinRestController {

    private CheckinRepositoryImpl checkinRepository;

    private CheckinService checkinService;

    public CheckinRestController(CheckinRepositoryImpl checkinRepository) {
        this.checkinRepository = checkinRepository;
    }

    @GetMapping("checkin")
    public ResponseEntity<List<Checkin>> findAllCheckins(){
        List<Checkin> check = checkinRepository.findAll();
        return ResponseEntity.ok(check);
    }

    @PostMapping("checkin")
    public ResponseTransfer createCheckin(@RequestBody CheckinForm checkinForm, Object employeeCheckinPage) {

        // ----get employeeId need completing by getting the id once the user has been logged in.
        Integer employeeId = 0;

        // gets date
        LocalDate now = LocalDate.now();

        CheckinDto checkinDto = new CheckinDto(null, 0, 1, now);
        checkinService.save(checkinDto);
        System.out.printf("employee checkin space" + employeeCheckinPage);
        return new ResponseTransfer("Checkin created successfully", "200");
    }
}
