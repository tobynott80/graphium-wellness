package uk.ac.cardiff.ASE2022Y2TEAM07.api;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.OneToOneService;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.message.ResponseTransfer;
import uk.ac.cardiff.ASE2022Y2TEAM07.web.forms.OneToOneForm;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class OneToOneRestController {
    private OneToOneService oneToOneService;

    @GetMapping("onetoone")
    public ResponseEntity<List<OneToOneDto>> findAllOneToOne() {
        return ResponseEntity.ok(oneToOneService.findAll());
    }

    @PostMapping("onetoone")
    public ResponseTransfer createOneToOne(@RequestBody OneToOneForm oneToOneForm) {
        //TODO: add one to one details to database
        return new ResponseTransfer("One to one created successfully", "200");
    }

    @PutMapping("onetoone")
    public ResponseTransfer updateOneToOne(@RequestBody OneToOneForm oneToOneForm) {
        //TODO: update one to one details in database
        return new ResponseTransfer("One to one updated successfully", "200");
    }
}