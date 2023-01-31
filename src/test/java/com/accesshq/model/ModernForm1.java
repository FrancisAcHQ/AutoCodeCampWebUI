package com.accesshq.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class ModernForm {
    private final WebDriver driver;

    public ModernForm(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void clickAgree() {
         driver.findElement(By.cssSelector("[for=agree]")).click();
    }

    public void clickSubmit() {
        var buttons = driver.findElements(By.cssSelector("button"));

        for (var button: buttons) {
            if (button.getText().equalsIgnoreCase("submit")) {
                button.click();
                break;
            }
        }
    }
}
