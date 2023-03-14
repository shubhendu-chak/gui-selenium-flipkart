package com.training;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FlipKartHomePageSearch {

    WebDriver driver;

    private void openFlipKart() {

        System.setProperty("webdriver.chrome.driver", "C:\\Professional\\Tools\\Selenium\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        String baseUrl = "https://www.flipkart.com/";
        driver.get(baseUrl);
        //operations


    }

    @Test(priority = 1)
    private void closeLogInWindow() throws InterruptedException {
        openFlipKart();

        WebElement closeInButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        //Thread.sleep(3000);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        closeInButton.click();
    }

    @Test(priority = 2)
    private void verifySearchTextIsDisplayed() {

        openFlipKart();

        WebElement closeInButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        if (closeInButton.isDisplayed()) {
            closeInButton.click();
        }

        //get the search text box element

        WebElement searchTextBox = driver.findElement(By.xpath("//input[@name='q']"));

        boolean isDisplayed = searchTextBox.isDisplayed();

        Assert.assertTrue(isDisplayed, "Does not match with actual"); //Hard Assert...there is soft Assert

        boolean isEnabled = searchTextBox.isEnabled();
        Assert.assertTrue(isEnabled, "Does not match with actual");

    }

    @Test(priority = 3)
    private void enterSearchTermAndClickSearch() {

        openFlipKart();
        WebElement closeInButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        if (closeInButton.isDisplayed()) {
            closeInButton.click();
        }

        //get the search text box element

        WebElement searchTextBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchTextBox.sendKeys("Mobile");


        WebElement searchButton = driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));
        searchButton.click();

    }

    @Test(enabled = false, priority = 4)
    private void searchWithEnter() {
        openFlipKart();
        WebElement closeInButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        if (closeInButton.isDisplayed()) {
            closeInButton.click();
        }

        //get the search text box element

        WebElement searchTextBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchTextBox.sendKeys("Mobile", Keys.RETURN);
    }

    @Test
    private void searchItemsVisibility() throws InterruptedException {
        openFlipKart();
        WebElement closeInButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        if (closeInButton.isDisplayed()) {
            closeInButton.click();
        }

        //get the search text box element

        WebElement searchTextBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchTextBox.sendKeys("Mobile", Keys.RETURN);

        //search result
        //WebElement searchResultText = driver.findElement(By.xpath("//span[contains(text(),'Showing 1 – 24')]"));
        //Assert.assertTrue(searchResultText.isDisplayed());
Thread.sleep(5000);
    }

    @Test
    private void verifyPresenceOfLogInButton() {

        openFlipKart();
        WebElement closeInButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        if (closeInButton.isDisplayed()) {
            closeInButton.click();
        }

        WebElement logInButton = driver.findElement(By.xpath("//a[@class='_1_3w1N']"));

        boolean isVisible = logInButton.isDisplayed();

        System.out.println("Which Text :" + logInButton.getText());
        Assert.assertTrue(isVisible);
    }


    @Test
    private void verifyPresenceOfSellerOption() {

        openFlipKart();

        WebElement closeInButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        if (closeInButton.isDisplayed()) {
            closeInButton.click();
        }

        WebElement sellerButton = driver.findElement(By.xpath("//a[@class='_3-PJz-']"));

        boolean isVisible = sellerButton.isDisplayed();

        System.out.println("Which Text :" + sellerButton.getText());
        Assert.assertTrue(isVisible);
    }

    @Test
    private void verifyLinkText() throws InterruptedException {

        openFlipKart();

        WebElement closeInButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        if (closeInButton.isDisplayed()) {
            closeInButton.click();
        }

        //Scroll down the webpage by 5000 pixels
    /*    JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0, 5000)");*/

        Thread.sleep(5000);

    /*    WebElement mobileTablest = driver.findElement(By.xpath("//a[@class='xtXmba']"));

        boolean isVisible = mobileTablest.isDisplayed();

        mobileTablest.click();*/


    }


    @AfterMethod
    private void teardown() {
        driver.quit();
    }
}
