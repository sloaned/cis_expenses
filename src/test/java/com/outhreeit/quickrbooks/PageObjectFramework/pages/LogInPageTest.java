package com.outhreeit.quickrbooks.PageObjectFramework.pages;

import com.outhreeit.quickrbooks.SeleniumFramework.Pages.LogInPage;
import com.outhreeit.quickrbooks.SeleniumFramework.TestPageObject;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

/**
 * Created by ddelaney on 12/9/2015.
 */
public class LogInPageTest extends TestPageObject {
    private final String VALID_USERNAME = "user";
    private final String SUPER_SECURE_VALID_PASSWORD = "root";
    
    @Test
    public void typeInAValidUserNameAndPasswordAndClickSubmit(){
        LogInPage logInPage = new LogInPage(driver);
        String expectedResult = "QuickrBooks";

        logInPage.sendKeys(By.name("username"), VALID_USERNAME);
        logInPage.sendKeys(By.name("password"), SUPER_SECURE_VALID_PASSWORD);
        logInPage.click(By.name("submit"));

        String actualResult = logInPage.getTitle();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void typeInAInvalidUserNameAndPasswordAndClickSubmit(){
        LogInPage logInPage = new LogInPage(driver);
        String expectedResult = "Login Page";

        logInPage.sendKeys(By.name("username"), SUPER_SECURE_VALID_PASSWORD);
        logInPage.sendKeys(By.name("password"), VALID_USERNAME);
        logInPage.click(By.name("submit"));

        String actualResult = logInPage.getTitle();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void tryToNavagateToAPageWhenYouHavNotLoggedInYet(){
        LogInPage logInPage = new LogInPage(driver);
        String expectedResult = "Login Page";

        logInPage.goTo("localhost:8080/expense-report");

        String actualResult = logInPage.getTitle();
        assertEquals(expectedResult, actualResult);
    }



}
