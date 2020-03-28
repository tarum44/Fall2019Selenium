package com.automation.tests.day13;

import org.testng.annotations.Test;

public class SystemProperties {

    @Test
    public void test(){

        // it shows us the directory
        System.out.println(System.getProperty("user.dir"));
        // it shows the os name used
        System.out.println(System.getProperty("os.name"));
        // flexible path to downloads folder
        // System.getProperty("user.home")+"/Downloads"
        System.out.println(System.getProperty("user.home"));

        String pathToDownloads = System.getProperty("user.home")+"/Downloads";

        System.out.println(pathToDownloads);

        System.out.println(System.getProperty("os.arch"));
    }
}
