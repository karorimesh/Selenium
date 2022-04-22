package com.example.Selenium.GetOTP;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;

public interface GetMessageUtil {
    /* Get email content from a mime message */
    public String getMessage(MimeMultipart mimeMultipart) throws MessagingException, IOException;
}
