package com.accesshq.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPlaygroundSuiteDay2Ex1 {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = GetWebDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
    }

    @Test
    public void TestInputSubmit() {
        long durationInSecs = 1;

        driver.findElement(By.id("forename")).sendKeys("Francis");
        driver.findElement(By.id("submit")).click();

        //WebElement popup = driver.findElement(By.className("popup-menu"));
        By popupMsgLocator = By.className("popup-message");
        new WebDriverWait(driver, durationInSecs).
            until(ExpectedConditions.visibilityOfElementLocated(popupMsgLocator));

        var result = driver.findElement(popupMsgLocator).getText();
        Assertions.assertEquals("Hello Francis", result);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    private WebDriver GetWebDriver() {
        return new ChromeDriver();
    }
}