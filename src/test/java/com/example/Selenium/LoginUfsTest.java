package com.example.Selenium;// Generated by Selenium IDE

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class LoginUfsTest {
  WebDriver driver;
  private final RestTemplate restTemplate = new RestTemplateBuilder().build();


  public LoginUfsTest(WebDriver driver) {
    this.driver = driver;
  }

  /*============ WAIT TO COMPENSATE FOR TIMEOUTS ================*/
  public void pause(){
    int time = 3;
    try {
      TimeUnit.SECONDS.sleep(time);
    } catch (InterruptedException e){
      System.out.println(e);
    }
  }
  public void pause( int time){
      try {
        TimeUnit.SECONDS.sleep(time);
      } catch (InterruptedException e){
        System.out.println(e);
      }
    }



  /* ========== SET UP TO RUN A MANAGED ENVIRONMENT ==============*/
  @Before
  public void setUp() throws MalformedURLException {
    System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--incognito");
    chromeOptions.setAcceptInsecureCerts(true);
    driver = new ChromeDriver(chromeOptions);
  }

  /*======== CLOSE CHROME WINDOW ================*/
  @After
  public void tearDown() {
    driver.findElement(By.cssSelector(".customer > .mat-card-image")).click();
    pause();
    driver.findElement(By.cssSelector(".fa-angle-down")).click();
    pause();
    driver.findElement(By.linkText("Log Out")).click();
    pause();
    pause();
    driver.quit();
  }

  /*===============Make a get request to API ==============*/
  public String makeApiCall(String url){
      return this.restTemplate.getForObject(url, String.class);
  }
  /*========== MAIN LOGIN TEST ================*/
  @Test
  public void loginUfs() throws InterruptedException {
    /*========= VARIABLE SCOPE ============*/
    String OTP = "000000";
    String email = "";
    driver.manage().window().maximize();
    driver.get("https://41.215.130.247:444/");
    pause();
    driver.findElement(By.name("email")).click();
    pause(5);
    driver.findElement(By.name("email")).sendKeys("karorimesh@gmail.com");

    email = driver.findElement(By.name("email")).getAttribute("value"); // Save the current email
    String url = "http://localhost:8080/selApi/getOTP";
    pause();
    driver.findElement(By.name("password")).click();
    pause();
    driver.findElement(By.name("password")).sendKeys("Data2020.");
    pause();
    driver.findElement(By.cssSelector(".btn")).click();
    pause();
    driver.findElement(By.id("no-paste")).click();
    pause(5);

    OTP = makeApiCall(url); // Retrieve the OTP

    pause(10);
    driver.findElement(By.id("no-paste")).sendKeys(OTP);
    pause();
    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
    pause(10);
  }
}