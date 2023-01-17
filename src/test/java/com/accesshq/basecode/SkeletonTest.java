package com.accesshq.basecode;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoilerPlateTest {

    private WebDriver driver;
    public static final String INITIAL_PAGE = "https://d18u5zoaatmpxx.cloudfront.net/";

    @BeforeEach
    public void setup() {
        driver = GetWebDriver();
        driver.get(INITIAL_PAGE);
    }
    
    @Test
    public void GenericTest() {
        
    }
    
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    private WebDriver GetWebDriver() {
        return new ChromeDriver();
    }
}
