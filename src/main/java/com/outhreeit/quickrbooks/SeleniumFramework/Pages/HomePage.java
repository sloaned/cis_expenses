package com.outhreeit.quickrbooks.SeleniumFramework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Scanner;

/**
 * Created by gfisher on 12/9/2015.
 */
public class HomePage extends LogInPage {
    public HomePage(WebDriver driver) {
        super(driver);
        sendKeys(By.name("username"), "LDAPUser");
        sendKeys(By.name("password"), "@oxXiS,;AIry\\{8wixuf3;f^?");
        click(By.name("submit"));
    }

}
