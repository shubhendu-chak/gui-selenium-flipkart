package com.training.locators.cssselector;

import com.training.flipkart.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.security.Key;

public class CssSelectorExamples {

    WebDriver driver;

    @Test
    private void verifyLogin() {

        driver = Common.openFlipKart();
        Common.closeLogInButton(driver);

        driver.manage().window().maximize();

        WebElement login=driver.findElement(By.cssSelector("._1_3w1N"));
        login.click();
    }

    @Test
    private void verifyLogin2() {

        driver = Common.openFlipKart();
        Common.closeLogInButton(driver);

        driver.manage().window().maximize();

        WebElement login=driver.findElement(By.cssSelector("a._1_3w1N"));
        login.click();
    }

    @Test
    private void verifySearchTextBox() {

        driver = Common.openFlipKart();
        Common.closeLogInButton(driver);

        driver.manage().window().maximize();

        WebElement searchTextBox=driver.findElement(By.cssSelector("[name='q']"));
        searchTextBox.click();
    }

    @Test
    private void verifySearchTextBoxWithInput() {

        driver = Common.openFlipKart();
        Common.closeLogInButton(driver);

        driver.manage().window().maximize();

        WebElement searchTextBox=driver.findElement(By.cssSelector("input[name='q']"));
        searchTextBox.sendKeys("Mobile", Keys.RETURN);
    }

    @Test
    private void navigateToHomePage() throws InterruptedException {

        driver = Common.openFlipKart();
        Common.closeLogInButton(driver);

        driver.manage().window().maximize();

        WebElement searchTextBox=driver.findElement(By.cssSelector("input[name='q']"));
        searchTextBox.sendKeys("Mobile", Keys.RETURN);

        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().forward();
    }

}
