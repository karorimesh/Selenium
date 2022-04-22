package com.example.Selenium;

import com.example.Selenium.SendAlert.SendAlertUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public class SendMailTest {
    @Autowired
    SendAlertUtil sendAlert ;

    @Test
    public void sendAlertTest() throws MessagingException, UnsupportedEncodingException {
    }
}
