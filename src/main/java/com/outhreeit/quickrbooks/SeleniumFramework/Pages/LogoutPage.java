package com.outhreeit.quickrbooks.SeleniumFramework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ddelaney on 12/9/2015.
 */
public class LogoutPage extends HomePage {
    public LogoutPage(WebDriver driver) {
        super(driver);

    }

    public void clickLogoutButton(){
        click(By.linkText("Logout"));
    }
}
