package com.example.Selenium.SendAlert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
@Component
public class SendAlertUtil {

    JavaMailSender mailSender;
    @Autowired
    public SendAlertUtil(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendAlert(AlertDTO alertDTO) throws MessagingException, UnsupportedEncodingException {
        MimeMessage registerMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(registerMessage);

        helper.setFrom("9ea88f1f-6f8d-475f-88b1-1530716fea98@catchall.tracom.dev","Support");
        helper.setTo(alertDTO.getSupporterEmails());
        String subject = "Service Down";
        String content = "<h3 style=\"color: red\"> "+ "Service" + "</h3>"
                +"<p> The " + alertDTO.getProjectName() + " Service is down</p>"
                +"<p> With response code: " + alertDTO.getResponseCode() + "</p>"
                +"<p>Downtime: "+ alertDTO.getTime() + "</p>";
        helper.setSubject(subject);
        helper.setText(content,true);
        mailSender.send(registerMessage);
    }

}
