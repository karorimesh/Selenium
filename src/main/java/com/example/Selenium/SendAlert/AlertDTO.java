package com.example.Selenium.SendAlert;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlertDTO {
    private String[] supporterEmails = {"karorimesh@gmail.com"};
    private String responseCode = "404";
    private String time = new Date().toString();
    private String projectName = "Project Name";

    public AlertDTO(String[] supporterEmails) {
        this.supporterEmails = supporterEmails;
    }
}
