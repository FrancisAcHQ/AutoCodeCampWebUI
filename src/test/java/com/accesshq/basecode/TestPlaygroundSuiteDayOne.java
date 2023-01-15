package com.accesshq;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TestPlaygroundSuite {

    @Test
    public void TestInputSubmit() {
        var driver = new ChromeDriver();
        long durationInSecs = 1000;

        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
        driver.findElement(By.id("forename")).sendKeys("Francis");
        driver.findElement(By.id("submit")).click();

        By popupMsgLocator = By.className("popup-message");
        WebElement wait = new WebDriverWait(driver, 10).
            until(ExpectedConditions.visibilityOfElementLocated(popupMsgLocator));
 
        var result = driver.findElement(popupMsgLocator).getText();

        Assertions.assertEquals("Hello Francis", result);
        driver.quit();
    }
}