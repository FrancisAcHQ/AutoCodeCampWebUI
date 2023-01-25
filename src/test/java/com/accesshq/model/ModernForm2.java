package com.accesshq.model;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.accesshq.basecode.Helper.clickElement;
import static com.accesshq.basecode.Helper.selectDropDown;

public class ModernForm {

    public ModernForm(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement nameInputElement;
    private WebElement emailInputElement;
    private WebElement stateDropDownElement;
    private WebElement agreeBoxElement;
    private final WebDriver driver;


    private WebElement getNameInputElement() {
        this.nameInputElement = driver.findElement(By.id("name"));
        return nameInputElement;
    }

    public void setNameInputElement(String name) {
        getNameInputElement().sendKeys(name);
    }

    private WebElement getEmailInputElement() {
        this.emailInputElement = driver.findElement(By.id("email"));
        return emailInputElement;
    }

    public void setEmailInputElement(String email) {
        getEmailInputElement().sendKeys(email);
    }

    private WebElement getStateDropDownElement() {
        this.stateDropDownElement = driver.findElement(By.id("state"));
        return stateDropDownElement;
    }

    public void setStateDropDownElement(String state) {
        try {
            selectDropDown(driver, getStateDropDownElement(), state);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    private WebElement getAgreeBoxElement() {
        this.agreeBoxElement =  driver.findElement(By.id("agree"));
        return agreeBoxElement;
    }

    public void setAgreeElement() {
        getAgreeBoxElement().sendKeys(Keys.SPACE);
    }

    public void submit() {
        clickElement(driver,"submit", "v-btn");
    }
}
