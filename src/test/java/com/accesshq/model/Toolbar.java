package com.accesshq.basecode;

import org.openqa.selenium.WebElement;

public class Toolbar {

    private WebElement webElement;

    public Toolbar(WebElement webElement) {
        this.webElement = webElement;
    }

    public void clickForms() {
        webElement.click();
    }
}
