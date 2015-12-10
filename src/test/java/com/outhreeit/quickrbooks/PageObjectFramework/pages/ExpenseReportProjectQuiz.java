package com.outhreeit.quickrbooks.PageObjectFramework.Pages;

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


    @Test
    public void addAProjectToExpenseReport(){
        ExpenseReportPage erp = new ExpenseReportPage(driver);
        erp.sendKeys(By.id("inputExpenseReportName"), VALID_NAME);
        Select dropdown = new Select(erp.find(By.id("selectDropdown")));
        dropdown.selectByIndex(1);
        String expected = dropdown.getOptions().get(1).getText();
        String actual = dropdown.getFirstSelectedOption().getText();
        assertEquals(expected, actual);
    }

    @Test
    public void addADifferentProjectToExpenseReport(){
        ExpenseReportPage erp = new ExpenseReportPage(driver);
        erp.sendKeys(By.id("inputExpenseReportName"), VALID_NAME);
        Select dropdown = new Select(erp.find(By.id("selectDropdown")));
        dropdown.selectByIndex(1);
        dropdown.selectByIndex(2);
        String expected = dropdown.getOptions().get(1).getText();
        String actual = dropdown.getFirstSelectedOption().getText();
        assertNotEquals(expected, actual);
    }

    @Test
    public void addProjectToExpenseReportAndSave(){
        ExpenseReportPage erp = new ExpenseReportPage(driver);
        erp.sendKeys(By.id("inputExpenseReportName"), VALID_NAME+"ProjectIncludedInExpenseReport");
        Select lineItem = new Select(erp.find(By.id("drpdwnvalue")));
        lineItem.selectByVisibleText("Mileage");
        Select dropdown = new Select(erp.find(By.id("selectDropdown")));
        dropdown.selectByVisibleText("KCLS");
        erp.getButtonByText("Save").click();
        String actual = erp.find(By.xpath("/html/body/div/ui-view/div/table/tbody/tr/td[last()]")).getText();
        String expected = VALID_NAME;
        assertEquals(expected, actual);
    }

}
