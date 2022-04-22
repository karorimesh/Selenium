package com.example.Selenium.GetOTP;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class GetOtp implements GetOtpUtil {
    @Override
    public String getOtp(String emailMessage, int otpLength) {
        StringBuilder OTP = new StringBuilder();
        String regEx = "([\\d]{" +otpLength +"}?)";
        Pattern patternOTP = Pattern.compile(regEx);
        Matcher matchingOTP = patternOTP.matcher(emailMessage);
        while ( matchingOTP.find()){
            OTP.append(matchingOTP.group());
            if (OTP.length()==otpLength){
                break;
            }
        }
        return OTP.toString();
    }
}
