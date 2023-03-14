package com.training.locators.classname;

import com.training.flipkart.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ClassLocator {

    WebDriver driver;
    @Test
    public void testWithClassType() {

        driver = Common.openFlipKart();
        Common.closeLogInButton(driver);
        driver.manage().window().maximize();

        WebElement logIn = driver.findElement(By.className("_1_3w1N"));

        Assert.assertTrue(logIn.isDisplayed());

        logIn.click();

    }

    @Test
    public void verifySearchText() {

        driver = Common.openFlipKart(); //opening flipkart page

        Common.closeLogInButton(driver); //closing login window
        driver.manage().window().maximize(); //maximizing it

        WebElement searchTextBox = driver.findElement(By.className("_3704LK"));

        Assert.assertTrue(searchTextBox.isDisplayed());

        searchTextBox.sendKeys("mobile", Keys.RETURN);


    }

    @Test
    public void verifyCartButton() {

        driver = Common.openFlipKart(); //opening flipkart page

        Common.closeLogInButton(driver); //closing login window
        driver.manage().window().maximize(); //maximizing it

        WebElement cartButton = driver.findElement(By.className("_3SkBxJ"));

        Assert.assertTrue(cartButton.isDisplayed());

        cartButton.click();

        WebElement emptyCartTextElement=driver.findElement(By.className("_1LCJ1U"));
        String text=emptyCartTextElement.getText();
        System.out.println(text);


    }


   /* @AfterTest
    private void terDown(){
        driver.quit();
    }*/
}
