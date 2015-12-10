package com.outhreeit.quickrbooks.PageObjectFramework.pages;

import com.outhreeit.quickrbooks.SeleniumFramework.Pages.ExpenseReportPage;
import com.outhreeit.quickrbooks.SeleniumFramework.TestPageObject;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by gfisher on 12/9/2015.
 */
public class ExpenseReportProjectQuiz extends TestPageObject{
    private final String VALID_NAME = "Expense Report Test Name";
    private ExpenseReportPage erp;

    @Before
    public void setUp(){
        erp = new ExpenseReportPage(driver);
        WebElement expenseReport = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("inputExpenseReportName")));
        expenseReport.sendKeys(VALID_NAME);
    }

    @Test
    public void addAProjectToExpenseReport(){
        Select dropdown = new Select(driver.findElement(By.id("selectDropdown")));
        dropdown.selectByIndex(1);
        String expected = dropdown.getOptions().get(1).getText();
        String actual = dropdown.getFirstSelectedOption().getText();
        assertEquals(expected, actual);
    }

    @Test
    public void addADifferentProjectToExpenseReport(){
        Select dropdown = new Select(driver.findElement(By.id("selectDropdown")));
        dropdown.selectByIndex(1);
        dropdown.selectByIndex(2);
        String expected = dropdown.getOptions().get(1).getText();
        String actual = dropdown.getFirstSelectedOption().getText();
        assertNotEquals(expected, actual);
    }

    @Test
    public void addProjectToExpenseReportAndSave(){
        Select dropdown = new Select(driver.findElement(By.id("selectDropdown")));
        dropdown.selectByVisibleText("KCLS");
        driver.findElement(By.xpath("//button")).click();
        WebElement newReport = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/ui-view/div/table/tbody/tr/td")));
        String expected = VALID_NAME;
        String actual = newReport.getText();
        assertEquals(expected, actual);
    }

}
