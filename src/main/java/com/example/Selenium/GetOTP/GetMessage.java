package com.example.Selenium.GetOTP;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;

@Service
public class GetMessage implements GetMessageUtil{

    @Override
    public String getMessage(MimeMultipart mimeMultipart) throws MessagingException, IOException {
        StringBuilder message = new StringBuilder();
        int mimeParts = mimeMultipart.getCount();
        for (int i = 0; i < mimeParts; i++){
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if(bodyPart.isMimeType("text/plain")){
                message.append("\n").append(bodyPart.getContent());
            } else if(bodyPart.isMimeType("text/html")){
                String html = (String) bodyPart.getContent();
                message.append("\n").append(Jsoup.parse(html).text());
            } else if (bodyPart.getContent() instanceof MimeMultipart){
                message.append(getMessage((MimeMultipart) bodyPart.getContent()));
            }
        }
        return message.toString();
    }
}
