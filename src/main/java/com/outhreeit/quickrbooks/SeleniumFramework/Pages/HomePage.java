package com.outhreeit.quickrbooks.SeleniumFramework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by gfisher on 12/9/2015.
 */
public class HomePage extends LogInPage {
    public HomePage(WebDriver driver) {
        super(driver);
        sendKeys(By.name("username"), "user");
        sendKeys(By.name("password"), "root");
        click(By.name("submit"));
    }

}
