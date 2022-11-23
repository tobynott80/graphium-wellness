package uk.ac.cardiff.ASE2022Y2TEAM07.api;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.CheckinDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.CheckinService;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.message.ResponseTransfer;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.forms.CheckinForm;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class CheckinRestController {

    private CheckinService checkinService;

    @GetMapping("checkin")
    public ResponseEntity<List<CheckinDto>> findAllCheckins(){
        return ResponseEntity.ok(checkinService.findAll());
    }

    @PostMapping("checkin")
    public ResponseTransfer createCheckin(@RequestBody CheckinForm checkinForm) {
        //TODO: add checkin details to database
        return new ResponseTransfer("Checkin created successfully", "200");
    }
}
