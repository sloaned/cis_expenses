package com.outhreeit.quickrbooks.SeleniumFramework.Pages;

import com.outhreeit.quickrbooks.SeleniumFramework.PageObject;
import org.openqa.selenium.WebDriver;

/**
 * Created by gfisher on 12/9/2015.
 */
public class LogInPage extends PageObject{
    public LogInPage(WebDriver driver) {
        super(driver);
        goTo("http://localhost:8080");
    }
}
