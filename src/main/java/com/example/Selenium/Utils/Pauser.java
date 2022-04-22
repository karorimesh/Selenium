package com.example.Selenium.Utils;

import java.util.concurrent.TimeUnit;

public class Pauser {
    public static void pause(){
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e){
            System.out.println(e);
        }
    }
    public static void pause( int time){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
