package uk.ac.cardiff.ASE2022Y2TEAM07.web.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;


import java.time.LocalDate;

@Data
@AllArgsConstructor
public class OneToOneForm {

    @Future(message = "Please enter a date for your meeting in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotEmpty(message = "Please enter a reason for your meeting")
    private String notes;

    public OneToOneForm() {
        this(LocalDate.now(), "");
    }
}
