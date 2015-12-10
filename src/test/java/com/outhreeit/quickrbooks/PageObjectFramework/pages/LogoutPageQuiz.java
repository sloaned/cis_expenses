package com.outhreeit.quickrbooks.PageObjectFramework.Pages;

import com.outhreeit.quickrbooks.SeleniumFramework.Pages.LogoutPage;
import com.outhreeit.quickrbooks.SeleniumFramework.TestPageObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ddelaney on 12/9/2015.
 */
public class LogoutPageQuiz extends TestPageObject {
    @Test
    public void clickOnTheLogoutButton() {
        LogoutPage logoutPage = new LogoutPage(driver);
        String expectedUrl = "http://localhost:8080/login?logout";
        logoutPage.clickLogoutButton();
        String actualUrl = logoutPage.getUrl();
        assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void clickOnTheLogoutButtonAndTryToGoToADifferentPage(){
        LogoutPage logoutPage = new LogoutPage(driver);
        String expectedUrl = "http://localhost:8080/login";
        logoutPage.clickLogoutButton();
        logoutPage.goTo("http://localhost:8080/expene-report");
        String actualUrl = logoutPage.getUrl();
        assertEquals(expectedUrl, actualUrl);
    }
}
