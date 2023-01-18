package com.accesshq.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {

    private WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPopupMsg() {
        long durationInSecs = 10;

        By popupMsgLocator = By.className("popup-message");
        new WebDriverWait(driver, durationInSecs).
            until(ExpectedConditions.visibilityOfElementLocated(popupMsgLocator));

        return driver.findElement(popupMsgLocator).getText();
    }

}
