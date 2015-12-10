package com.outhreeit.quickrbooks.PageObjectFramework.pages;

import com.outhreeit.quickrbooks.SeleniumFramework.Pages.ExpenseReportPage;
import com.outhreeit.quickrbooks.SeleniumFramework.TestPageObject;
import com.thoughtworks.selenium.Wait;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * Created by ddelaney on 12/9/2015.
 */
public class CreateExpenseReportQuiz extends TestPageObject {
    private final String VALID_NAME = "hey im a valid name";

    @Test
    public void typeSomeTextInTheNameFieldAndClickOnTheSaveButton(){
        ExpenseReportPage expenseReportPage = new ExpenseReportPage(driver);
        String expected = VALID_NAME;
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("inputExpenseReportName")));
        expenseReportPage.sendKeys(By.id("inputExpenseReportName"),VALID_NAME);
        expenseReportPage.getButtonByText("Save").click();

        String actual = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))).getText();

        assertEquals(expected, actual);
    }
}
