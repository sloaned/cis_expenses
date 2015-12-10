package com.outhreeit.quickrbooks.PageObjectFramework.Pages;

import com.outhreeit.quickrbooks.SeleniumFramework.Pages.ExpenseReportPage;
import com.outhreeit.quickrbooks.SeleniumFramework.TestPageObject;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by ddelaney on 12/9/2015.
 */
public class CreateExpenseReportQuiz extends TestPageObject {
    private final String VALID_NAME = "hey im a valid name";

    @Test
    public void typeSomeTextInTheNameFieldAndClickOnTheSaveButtonItShouldFail(){
        ExpenseReportPage expenseReportPage = new ExpenseReportPage(driver);
        String expected = VALID_NAME;
        expenseReportPage.sendKeys(By.id("inputExpenseReportName"),VALID_NAME);

        String actual = "";

        assertNotEquals(expected, actual);
    }
}
