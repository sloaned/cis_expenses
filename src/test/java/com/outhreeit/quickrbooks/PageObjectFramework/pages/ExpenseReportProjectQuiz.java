package com.outhreeit.quickrbooks.PageObjectFramework.Pages;

import com.outhreeit.quickrbooks.SeleniumFramework.Pages.ExpenseReportPage;
import com.outhreeit.quickrbooks.SeleniumFramework.Pages.HomePage;
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
        HomePage homePage = new HomePage(driver);
        int expected = homePage.findElements(By.xpath("/html/body/div/ui-view/div/table/tbody/tr")).size()+1;
        homePage.find(By.linkText("Create")).click();
        homePage.find(By.linkText("Expense Report")).click();
        homePage.sendKeys(By.id("inputExpenseReportName"), VALID_NAME+"ProjectIncludedInExpenseReport");
        Select lineItem = new Select(homePage.find(By.id("drpdwnvalue")));
        lineItem.selectByVisibleText("Mileage");
        Select dropdown = new Select(homePage.find(By.id("selectDropdown")));
        dropdown.selectByVisibleText("KCLS");
        homePage.getButtonByText("Save").click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/ui-view/div/table/tbody/tr["+expected+"]")));
        int actual = homePage.findElements(By.xpath("/html/body/div/ui-view/div/table/tbody/tr")).size();
        assertEquals(expected, actual);
    }

}
