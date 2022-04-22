package com.example.Selenium.SendAlert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/sendAlert")
public class SendAlertController {
    private final SendAlertUtil sendAlertUtil;

    @Autowired
    public SendAlertController(SendAlertUtil sendAlertUtil) {
        this.sendAlertUtil = sendAlertUtil;
    }

    @PostMapping("")
    public ResponseEntity<String> sendEmail(@RequestBody AlertDTO alertDTO) throws MessagingException, UnsupportedEncodingException {
        sendAlertUtil.sendAlert(alertDTO);
        return ResponseEntity.status(HttpStatus.OK).body("done");
    }
}
