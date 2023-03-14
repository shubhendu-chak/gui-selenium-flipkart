package com.training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FlipKartHomePageVerification {

    WebDriver driver;

    private void openFlipKart() {

        System.setProperty("webdriver.chrome.driver", "C:\\Professional\\Tools\\Selenium\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        String baseUrl = "https://www.flipkart.com/";

        driver.get(baseUrl);
        driver.manage().window().maximize();
        //operations


    }

    @Test
    private void closeLogInWindow() throws InterruptedException {
        this.openFlipKart();
        WebElement closeInButton = this.driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        //this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        closeInButton.click();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    private void verifyFlipKartTitle() {

        String expectedString = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
        openFlipKart();

        String title = driver.getTitle();

        System.out.println("Title is: " + title);

        Assert.assertEquals(title, expectedString, "Title mismatch occured");
    }

    @Test(priority = 2)
    private void verifySearchAtrributes() {
        openFlipKart();
        WebElement webElement = driver.findElement(By.name("q"));

        String elementTitle = webElement.getAttribute("title");
        Assert.assertEquals(elementTitle, "Search for products, brands and more", "Element Title mismatch");
    }

    @Test
    private void verifyPlaceHolderAttriBute() {
        openFlipKart();
        WebElement webElement = driver.findElement(By.name("q"));
        String placeHolder = webElement.getAttribute("placeholder");
        Assert.assertEquals(placeHolder, "Search for products, brands and more", "Element Placeholder value mismatch");

    }

    @Test(description = "This is to test if page title contains a specific item")
    private void verifyFlipKartTitleContains() {

        String expectedString = "Electronics";
        openFlipKart();

        String title = driver.getTitle();

        System.out.println("Title is: " + title);

        Assert.assertTrue(title.contains(expectedString), "Title should contain the expected string");
    }

    @Test
    private void verifyCurrentUrl() {
        openFlipKart();
        String expectedCurrentUrl = "https://www.flipkart.com/";

        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(actualUrl, expectedCurrentUrl, "Current url should match");
    }

    @Test
    private void verifyClearMethod() throws InterruptedException {
        openFlipKart();
        WebElement webElement = driver.findElement(By.name("q"));
        WebElement closeInButton = this.driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        if (closeInButton.isDisplayed()) {
            closeInButton.click();
        }
        webElement.sendKeys("Trying to search electronic items");
        Thread.sleep(5000);
        webElement.clear();
        Thread.sleep(3000);
    }

    @Test
    private void enterSearchTermAndClickSearch() throws InterruptedException {
        this.openFlipKart();
        WebElement closeInButton = this.driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        if (closeInButton.isDisplayed()) {
            closeInButton.click();
        }

        WebElement searchTextBox = this.driver.findElement(By.xpath("//input[@name='q']"));
        searchTextBox.sendKeys(new CharSequence[]{"Mobile"});
        WebElement searchButton = this.driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));
        searchButton.click();
        Thread.sleep(5000);
    }

    @AfterMethod
    private void teardown() {
        driver.close();
    }
}
