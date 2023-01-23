package com.accesshq.tests;

import com.accesshq.model.Planet;
import com.accesshq.model.PlanetPage;
import com.accesshq.model.PlanetsPage;
import com.accesshq.model.Toolbar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestPlayGndSuiteDay3Ex2 {

    private WebDriver driver;
    public static final String INITIAL_PAGE = "https://d18u5zoaatmpxx.cloudfront.net/";

    @BeforeEach
    public void setup() {
        this.driver = GetWebDriver();
        driver.get(INITIAL_PAGE);
    }

    @Test
    public void ExploreEarth() throws Exception {
        /*
            1. Click on the 'Planets' tab
            2. Find all the planets
            3. Click on the "Explore" button associated with the farthest planet from the Sun
         */
        String farthestPlanetFromSun = "";

        /* 1. Arrange (Given)
           ================== */
        /* Click into Form */
        new Toolbar(driver, "planets", "v-btn__content").clickPlanetsTab();

        PlanetsPage page = new PlanetsPage(driver);
        List<Planet> planets = page.getAllPlanets();
        farthestPlanetFromSun = page.getPlanetFarthestFromSun(planets);
        System.out.println("Farthest Planet from the Sun: " + farthestPlanetFromSun);

        /* 2. Act (When)
           ================== */
        new Toolbar(driver, farthestPlanetFromSun.toLowerCase(), "name").clickEarthButton();

        /* 3. Assert (then)
           ================== */
        String expectedResult = "Exploring Neptune";
        Assertions.assertEquals(expectedResult, new PlanetsPage(driver).getPopupMsg());
    }


    private WebDriver GetWebDriver() {
        return new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
