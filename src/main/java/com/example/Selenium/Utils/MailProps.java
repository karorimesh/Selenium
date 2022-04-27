package com.example.Selenium.Utils;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MailProps {
    private String emailSource = "tracom.tms@gmail.com";
    private String emailPassword = "Data2018.";
    private String emailTo = "";
    private String serverHost = "imap.gmail.com";
    private String serverPort = "993";
    private boolean toInbox = false;
    private int otpLength = 6;
    private int retrieveTrials = 5;
    private String inboxFolderName = "INBOX";
    private String sentFolderName = "[Gmail]/Sent Mail";
    private boolean sendAlert = false;
    private String alertMessage = "";

    /*==================== SENT FOLDER =========================*/
    /* Get OTP from latest email sent using my default configs */
    public MailProps() {
    }
    /* Get from my email configs mail to a specific email */
    public MailProps(String emailTo) {
        this.emailTo = emailTo;
    }

    /* Get from my email configs mail to a specific email with specified number of trials*/
    public MailProps(String emailTo, int retrieveTrials) {
        this.emailTo = emailTo;
        this.retrieveTrials = retrieveTrials;
    }
    /* Get from the latest email from a gmail credentials */
    public MailProps(String emailSource, String emailPassword) {
        this.emailSource = emailSource;
        this.emailPassword = emailPassword;
    }
    /* Get from the latest email from different gmail credentials and the email to: */
    public MailProps(String emailSource, String emailPassword, String emailTo) {
        this.emailSource = emailSource;
        this.emailPassword = emailPassword;
        this.emailTo = emailTo;
    }
    /* Get from the latest email from different gmail credentials and the email to: with specified tries */
    public MailProps(String emailSource, String emailPassword, String emailTo, int retrieveTrials) {
            this.emailSource = emailSource;
            this.emailPassword = emailPassword;
            this.emailTo = emailTo;
            this.retrieveTrials = retrieveTrials;
        }

    /* Get from the latest email from a non-gmail account */
    public MailProps(String emailSource, String emailPassword,
                     String serverHost, String serverPort, String sentFolderName) {
        this.emailSource = emailSource;
        this.emailPassword = emailPassword;
        this.serverHost = serverHost;
        this.serverPort = serverPort;
        this.sentFolderName = sentFolderName;
    }

    /* Get from the latest email from a non-gmail account sent to a specified email*/

    public MailProps(String emailSource, String emailPassword,
                     String emailTo, String serverHost,
                     String serverPort, String sentFolderName) {
        this.emailSource = emailSource;
        this.emailPassword = emailPassword;
        this.emailTo = emailTo;
        this.serverHost = serverHost;
        this.serverPort = serverPort;
        this.sentFolderName = sentFolderName;
    }

    /* Get from the latest email from a non-gmail account sent to a specified email with a given number of tries*/

    public MailProps(String emailSource, String emailPassword,
                     String emailTo, String serverHost,
                     String serverPort, String sentFolderName, int retrieveTrials) {
        this.emailSource = emailSource;
        this.emailPassword = emailPassword;
        this.emailTo = emailTo;
        this.serverHost = serverHost;
        this.serverPort = serverPort;
        this.sentFolderName = sentFolderName;
        this.retrieveTrials = retrieveTrials;
    }

    /*========================= INBOX FOLDER ===========================*/
    /* Get from Inbox of the recipient gmail type */
    public MailProps(String emailPassword, String emailTo, boolean toInbox) {
        this.emailPassword = emailPassword;
        this.emailTo = emailTo;
        this.toInbox = toInbox;
    }
    /* Get from Inbox of the recipient gmail type with retrieve trials*/
    public MailProps(String emailPassword, String emailTo, boolean toInbox, int retrieveTrials) {
        this.emailPassword = emailPassword;
        this.emailTo = emailTo;
        this.toInbox = toInbox;
        this.retrieveTrials =retrieveTrials;
    }

    /* Get from inbox of a non-gmail recipient */

    public MailProps(String emailPassword, String emailTo,
                     String serverHost, String serverPort,
                     boolean toInbox, String inboxFolderName) {
        this.emailPassword = emailPassword;
        this.emailTo = emailTo;
        this.serverHost = serverHost;
        this.serverPort = serverPort;
        this.toInbox = toInbox;
        this.inboxFolderName = inboxFolderName;
    }

    /* Get from inbox of a non-gmail recipient with retrieve trials*/

    public MailProps(String emailPassword, String emailTo,
                     String serverHost, String serverPort,
                     boolean toInbox, String inboxFolderName, int retrieveTrials) {
        this.emailPassword = emailPassword;
        this.emailTo = emailTo;
        this.serverHost = serverHost;
        this.serverPort = serverPort;
        this.toInbox = toInbox;
        this.inboxFolderName = inboxFolderName;
        this.retrieveTrials = retrieveTrials;
    }
}
