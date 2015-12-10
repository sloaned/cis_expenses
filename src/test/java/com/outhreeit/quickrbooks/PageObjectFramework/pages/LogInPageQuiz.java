package com.outhreeit.quickrbooks.PageObjectFramework.Pages;

import com.outhreeit.quickrbooks.SeleniumFramework.Pages.HomePage;
import com.outhreeit.quickrbooks.SeleniumFramework.Pages.LogInPage;
import com.outhreeit.quickrbooks.SeleniumFramework.TestPageObject;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

/**
 * Created by ddelaney on 12/9/2015.
 */
public class LogInPageQuiz extends TestPageObject {
    private final String VALID_USERNAME = "user";
    private final String SUPER_SECURE_VALID_PASSWORD = "root";

    @Test
    public void typeInAValidUserNameAndPasswordAndClickSubmit(){
        HomePage homepage = new HomePage(driver);
        String expectedResult = "QuickrBooks";
        String actualResult = homepage.getTitle();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void typeInAInvalidUserNameAndPasswordAndClickSubmit(){
        LogInPage logInPage = new LogInPage(driver);
        String expectedResult = "Login";

        logInPage.sendKeys(By.name("username"), SUPER_SECURE_VALID_PASSWORD);
        logInPage.sendKeys(By.name("password"), VALID_USERNAME);
        logInPage.getButtonByText("Log In").click();

        String actualResult = logInPage.getTitle();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void tryToNavagateToAPageWhenYouHavNotLoggedInYet(){
        LogInPage logInPage = new LogInPage(driver);
        String expectedResult = "Login";

        logInPage.goTo("localhost:8080/expense-report");

        String actualResult = logInPage.getTitle();
        assertEquals(expectedResult, actualResult);
    }



}
