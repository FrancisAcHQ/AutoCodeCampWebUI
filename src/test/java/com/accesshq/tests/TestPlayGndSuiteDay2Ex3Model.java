package com.accesshq.tests;

import com.accesshq.model.FormPage;
import com.accesshq.basecode.Helper;
import com.accesshq.model.ModernForm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPlayGndSuiteDay2Ex2Model {

    private WebDriver driver;
    public static final String INITIAL_PAGE = "https://d18u5zoaatmpxx.cloudfront.net/";
    public static final String givenName = "Francis McSwiggan";

    @BeforeEach
    public void setup() {
        this.driver = GetWebDriver();
        driver.get(INITIAL_PAGE);
    }

    @Test
    public void TestModernFormInput() {

        /* 1. Arrange (Given)
           ================== */
        /* Click into Form */
        Helper.clickElement(driver, "forms", "v-btn");
        Helper.clickElement(driver, "modern", "v-tab");

        ModernForm form = new ModernForm(driver);
        form.setNameInputElement(givenName);
        form.setEmailInputElement("francis.mcswiggan@accesshq.com");
        form.setStateDropDownElement("tas");
        form.setAgreeElement();

        /* 2. Act (When)
           ================== */
        form.submit();

        /* 3. Assert (then)
           ================== */
        String expectedResult = "Thanks for your feedback " + givenName;
        Assertions.assertEquals(expectedResult, new FormPage(driver).getPopupMsg());

    }


    private WebDriver GetWebDriver() {
        return new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
