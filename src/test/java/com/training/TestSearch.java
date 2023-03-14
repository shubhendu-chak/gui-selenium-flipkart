package com.training;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSearch {

    @Test
    private static void openGoogleSearch(){

        System.setProperty("webdriver.chrome.driver", "C:\\Professional\\Tools\\Selenium\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        WebElement e = driver.findElement(By.name("q"));

        driver.findElement(By.name("q")).sendKeys("Software is funny", Keys.RETURN);



    }

}
