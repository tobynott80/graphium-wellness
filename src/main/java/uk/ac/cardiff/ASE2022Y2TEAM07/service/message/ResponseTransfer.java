package uk.ac.cardiff.ASE2022Y2TEAM07.service.message;

import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This class is used to transfer messages to the front end
 */
@ResponseBody
public class ResponseTransfer {
    private String message;
    private String status;

    public ResponseTransfer(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
