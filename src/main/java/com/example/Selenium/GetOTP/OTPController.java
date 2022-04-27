package com.example.Selenium.GetOTP;

import com.example.Selenium.Utils.MailProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@RequestMapping("/selApi")
public class OTPController {

    private RetrieveSent retrieveSent;
    private RetrieveSent retrieveSentPost;

    @Autowired
    public OTPController(RetrieveSent retrieveSent, RetrieveSent retrieveSentPost) {
        this.retrieveSent = retrieveSent;
        this.retrieveSentPost = retrieveSentPost;
    }

    @GetMapping("/getOTP")
    public ResponseEntity<String> getOTP() throws MessagingException, IOException {
        String OTP = retrieveSent.retrieveMail(new MailProps());
        return ResponseEntity.status(HttpStatus.OK).body(OTP);
    }

    @GetMapping("/getOTP/{otpSize}")
    public ResponseEntity<String> getOTP(@PathVariable int otpSize) throws MessagingException, IOException {
        MailProps mailProps = new MailProps();
        mailProps.setOtpLength(otpSize);
        String OTP = retrieveSent.retrieveMail(mailProps);
        return ResponseEntity.status(HttpStatus.OK).body(OTP);
    }

    @PostMapping("/getOTP")
    public ResponseEntity<String> getOTP(@RequestBody MailProps mailProps) throws MessagingException, IOException {
        String OTP = retrieveSentPost.retrieveMail(mailProps);
        return ResponseEntity.status(HttpStatus.OK).body(OTP);
    }

    @PostMapping("/getOTP/{otpSize}")
    public ResponseEntity<String> getOTP(@RequestBody MailProps mailProps, @PathVariable int otpSize) throws MessagingException, IOException {
        mailProps.setOtpLength(otpSize);
        String OTP = retrieveSentPost.retrieveMail(mailProps);
        return ResponseEntity.status(HttpStatus.OK).body(OTP);
    }
}
