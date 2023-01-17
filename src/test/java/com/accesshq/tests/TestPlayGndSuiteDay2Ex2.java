package com.accesshq.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TestPlaygroundSuiteDay2Ex2 {

    private WebDriver driver;
    public static final String INITIAL_PAGE = "https://d18u5zoaatmpxx.cloudfront.net/";
    public static final String givenName = "Francis McSwiggan";

    @BeforeEach
    public void setup() {
        driver = GetWebDriver();
        driver.get(INITIAL_PAGE);
    }

    @Test
    public void TestModernFormInput() throws InterruptedException {
        long durationInSecs = 10;

        /* Click into Form */
        clickElement("forms", "v-btn");
        clickElement("modern", "v-tab");

        /* Get elements for Name, Email & State */
        WebElement nameInputElement = driver.findElement(By.id("name"));
        WebElement emailInputElement = driver.findElement(By.id("email"));
        WebElement stateDropdownElement = driver.findElement(By.id("state"));

        /* Fill values for Name, Email and State */
        nameInputElement.sendKeys(givenName);
        emailInputElement.sendKeys("francis.mcswiggan@accesshq.com");
        selectState(stateDropdownElement, "nsw");

        /* Click on Do you agree */
        WebElement agreeBoxElement = driver.findElement(By.id("agree"));
        agreeBoxElement.sendKeys(Keys.SPACE);

        /* Click Submit */
        clickElement("submit", "v-btn");

        /* Check on the Popup menu */
        By popupMsgLocator = By.className("popup-message");
        new WebDriverWait(driver, durationInSecs).
            until(ExpectedConditions.visibilityOfElementLocated(popupMsgLocator));

        var result = driver.findElement(popupMsgLocator).getText();

        /* Assert that something has been done */
        String expectedResult = "Thanks for your feedback " + givenName;
        Assertions.assertEquals(expectedResult, result);

    }

    private void clickElement(String elementName, String elementClass) {

        List<WebElement> elements = driver.findElements(By.className(elementClass));
        for(WebElement currentElement: elements) {
            if(currentElement.getText().equalsIgnoreCase(elementName)) {
                currentElement.click();
                break;
            }
        }
    }

    private void selectState(WebElement stateDropdownElement, String state) throws InterruptedException {

        driver.findElement(By.xpath("//div[@class='v-input__append-inner']")).click();
        stateDropdownElement.sendKeys(Keys.DOWN);
        Thread.sleep(10);

        List<WebElement> allOptions = stateDropdownElement.findElements(By.xpath("//div[@class='v-list-item__content']"));
        for(WebElement we: allOptions) {
            if (we.findElement(By.xpath("./div[@class='v-list-item__title']")).getText().equalsIgnoreCase(state)) {
                stateDropdownElement.sendKeys(Keys.ENTER);
                break;
            }
            stateDropdownElement.sendKeys(Keys.DOWN);
            Thread.sleep(10);
        }
    }

    private WebDriver GetWebDriver() {
        return new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
