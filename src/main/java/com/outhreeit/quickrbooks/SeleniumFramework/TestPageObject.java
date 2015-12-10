package com.outhreeit.quickrbooks.SeleniumFramework;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by gfisher on 12/9/2015.
 */
public abstract class TestPageObject {
    protected WebDriver driver;
    SeleniumSettings seleniumSettings;

    @Before
    public void setup(){
        seleniumSettings = new SeleniumSettings();
        driver = seleniumSettings.getDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
