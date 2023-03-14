package com.training.locators.xpath;

import com.training.flipkart.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XpathExample {

    WebDriver driver;

    @Test
    public void verifyCartWithRelativeXPath() {

        driver = Common.openFlipKart();
        Common.closeLogInButton(driver);
        driver.manage().window().maximize();

        WebElement cart = driver.findElement(By.xpath("//span[contains(text(),'Cart')]"));

        Assert.assertTrue(cart.isDisplayed());

        cart.click();

    }

    @Test
    public void verifyCartWithAbsoluteXPath() {

        driver = Common.openFlipKart();
        Common.closeLogInButton(driver);
        driver.manage().window().maximize();

        WebElement cart = driver.findElement(By.xpath(" /html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[6]/div[1]/div[1]/a[1]/span[1]"));

        Assert.assertTrue(cart.isDisplayed());

        cart.click();

    }

    @Test
    public void verifyCartWithDifferentXPath() {

        driver = Common.openFlipKart();
        Common.closeLogInButton(driver);
        driver.manage().window().maximize();

        WebElement cart = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[6]/div/div/a/span"));

        Assert.assertTrue(cart.isDisplayed());

        cart.click();

    }



}
