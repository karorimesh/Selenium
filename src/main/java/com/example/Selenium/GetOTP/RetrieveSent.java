package com.example.Selenium.GetOTP;

import com.example.Selenium.MailProps;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;

@Service
@Getter
@Setter
public class RetrieveSent implements RetrieveSentUtil{

    static int i = 0;     /* Help to retrieve the next email */

    private GetMessage getEmailMessage;
    private GetOtp getOtp;

    @Autowired
    public RetrieveSent(GetMessage getEmailMessage, GetOtp getOtp) {
        this.getEmailMessage = getEmailMessage;
        this.getOtp = getOtp;
    }

    public RetrieveSent() {
    }

    @Override
    public String retrieveMail(MailProps mailProps) throws MessagingException, IOException {
        /* ===== SET UP PROPS TO RETRIEVE EMAIL ========*/
        Folder folderMails;
        String retrievedOTP = "No OTP";
        boolean OTPNotRetrieved = true;
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        props.setProperty("mail.imap.port", mailProps.getServerPort());

        /*======== CREATE A JAVAX MAIL SESSION ========*/
        Session session = Session.getInstance(props, null);
        Store store = session.getStore();

        /*====== PROVIDE CREDENTIALS TO CONNECT ========*/
        store.connect(mailProps.getServerHost(),
                        mailProps.isToInbox()? mailProps.getEmailTo() : mailProps.getEmailSource(),
                        mailProps.getEmailPassword());

        /*====== GET SENT BOX OR INBOX FOLDER CONTENTS ==========*/
        if(mailProps.isToInbox()){
            folderMails = store.getFolder(mailProps.getInboxFolderName());
        }else {
            folderMails = store.getFolder(mailProps.getSentFolderName());
        }
        folderMails.open(Folder.READ_ONLY);

        /* ============= Iterate until you find the right OTP ========== */
        while(OTPNotRetrieved){
            int emailIndex = folderMails.getMessageCount() - i;
            Message msg = folderMails.getMessage(emailIndex);
            Address[] recipient = msg.getRecipients(Message.RecipientType.TO);
            if((recipient[0].toString().equals(mailProps.getEmailTo())) ||
                    mailProps.getEmailTo().isBlank() ||
                    mailProps.getEmailSource().isBlank()){

                MimeMultipart mp = (MimeMultipart) msg.getContent();
                String message = getEmailMessage.getMessage(mp);
                retrievedOTP = getOtp.getOtp(message, mailProps.getOtpLength());
                OTPNotRetrieved = false;
                if(folderMails.getName().equals(mailProps.getInboxFolderName()) &&
                        retrievedOTP.isBlank()){
                    i++;
                    OTPNotRetrieved = i != mailProps.getRetrieveTrials();
                }
            }

            else {
                i++;
                if(i == mailProps.getRetrieveTrials()){
                    OTPNotRetrieved = false;
                }
            }
        }

        store.close();
        i = 0;
        return retrievedOTP;
    }
}
