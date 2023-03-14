package com.training.flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Common {

    private final static String CHROME_DRIVER_PATH = "<Driver Path>\\chromedriver.exe";

    public static WebDriver openFlipKart() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();

        String baseUrl = "https://www.flipkart.com/";
        driver.get(baseUrl);
        return driver;

    }

    public static WebDriver openFlipKartWithWindowMaximized() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);

        String baseUrl = "https://www.flipkart.com/";
        driver.get(baseUrl);
        return driver;

    }

    public static void closeLogInButton(WebDriver driver) {
        WebElement closeInButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));

        if (closeInButton.isDisplayed()) {
            closeInButton.click();
        }

    }
}
