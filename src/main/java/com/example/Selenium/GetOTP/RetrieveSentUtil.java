package com.example.Selenium.GetOTP;

import com.example.Selenium.MailProps;

import javax.mail.MessagingException;
import java.io.IOException;

public interface RetrieveSentUtil {
    /* Retrieve Email Mime message */
    public String retrieveMail(MailProps mailProps) throws MessagingException, IOException;
}
