package com.example.Selenium.GetOTP;

public interface GetOtpUtil {
    /* Retrieve OTP from message */
    public String getOtp(String emailMessage, int otpLength);
}
