package com.pruebas.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;


public class ScreenShots {
    public static void screenShots(WebDriver driver, String name){
        LocalDateTime now = LocalDateTime.now();

        // Formatear la fecha y hora a un formato seguro para nombres de archivo
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String formattedDateTime = now.format(formatter);

        String filePath = "screenshots/" +name+formattedDateTime + ".png";
        File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File(filePath));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
