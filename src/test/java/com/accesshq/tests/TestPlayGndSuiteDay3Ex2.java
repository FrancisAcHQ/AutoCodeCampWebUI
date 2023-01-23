package com.accesshq.tests;

import com.accesshq.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestPlayGndSuiteDay3Ex1 {

    private WebDriver driver;
    public static final String INITIAL_PAGE = "https://d18u5zoaatmpxx.cloudfront.net/";

    @BeforeEach
    public void setup() {
        this.driver = GetWebDriver();
        driver.get(INITIAL_PAGE);
    }

    @Test
    public void ExploreEarth() {
        /*
            1. Click on the 'Planets' tab
            2. Find all the planets
            3. Click on the "Explore" button associated with planet Earth
         */
        String currentPlanet = "Mars";

        /* 1. Arrange (Given)
           ================== */
        /* Click into Form */
        new Toolbar(driver, "planets", "v-btn__content").clickPlanetsTab();

        PlanetsPage page = new PlanetsPage(driver);
        List<String> planets = page.getAllPlanets();

        /* 2. Act (When)
           ================== */
        new Toolbar(driver, currentPlanet.toLowerCase(), "name").clickEarthButton();

        /* 3. Assert (then)
           ================== */
        String expectedResult = "Exploring " + currentPlanet;
        Assertions.assertEquals(expectedResult, new PlanetPage(driver).getPopupMsg());

    }


    private WebDriver GetWebDriver() {
        return new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
