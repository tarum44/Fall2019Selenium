package com.automation.tests.day5;

public class BrowersUtils {

        public static void wait(int seconds){
            try {
                Thread.sleep(1000 * seconds);
            }catch (InterruptedException e){
                e.printStackTrace();
        }


    }
}
