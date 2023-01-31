package com.accesshq.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Toolbar {

    private WebElement toolbarElement;

    public Toolbar(WebElement toolbarElement) {
        this.toolbarElement = toolbarElement;
    }

    public void clickForms() {
        List<WebElement> buttons = toolbarElement.findElements(By.cssSelector("[v-btn__content]"));

        for(var button: buttons) {
            if (button.getText().equalsIgnoreCase("forms")) {
                button.click();
                break;
            }
        }
    }

}
