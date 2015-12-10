package com.outhreeit.quickrbooks.PageObjectFramework.Pages;

import com.outhreeit.quickrbooks.SeleniumFramework.Pages.ExpenseReportPage;
import com.outhreeit.quickrbooks.SeleniumFramework.TestPageObject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by gfisher on 12/9/2015.
 */
public class ExpenseReportLineItemQuiz extends TestPageObject{

    private final String VALID_VALUE = "3200";
    private ExpenseReportPage erp;
    private final String VALID_NAME = "Expense Report Test Name";



    @Test
    public void addALineItemToTheExpenseReportSuccessfullyTest(){
        ExpenseReportPage erp = new ExpenseReportPage(driver);
        erp.sendKeys(By.id("inputExpenseReportName"), VALID_NAME);
        Select dropdown = new Select(driver.findElement(By.id("drpdwnvalue")));
        dropdown.selectByVisibleText("Mileage");
        WebElement newRow = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/ui-view/div/div[2]/label")));
        String expected = "Mileage";
        String actual = newRow.getText();
        assertEquals(expected, actual);
    }

    @Test
    public void addALineItemThatAlreadyExistsToExpenseReportFailsTests(){
        ExpenseReportPage erp = new ExpenseReportPage(driver);
        erp.sendKeys(By.id("inputExpenseReportName"), VALID_NAME);
        int current = erp.findElements(By.xpath("/html/body/div/ui-view/div/div")).size();
        int expected = current+2;
        Select dropdown = new Select(driver.findElement(By.id("drpdwnvalue")));
        dropdown.selectByVisibleText("Mileage");
        WebElement mileageRow = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/ui-view/div/div[2]/label")));
        dropdown.selectByVisibleText("Lodging");
        WebElement lodgingRow = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/ui-view/div/div[3]/label")));
        dropdown.selectByVisibleText("Mileage");
        int actual = driver.findElements(By.xpath("/html/body/div/ui-view/div/div")).size();
        assertEquals(expected, actual);
    }

    @Test
    public void addALineItemToExpenseReportClickSubmitNavigatesToHomePage(){
        ExpenseReportPage erp = new ExpenseReportPage(driver);
        erp.sendKeys(By.id("inputExpenseReportName"), VALID_NAME);
        Select dropdown = new Select(driver.findElement(By.id("drpdwnvalue")));
        dropdown.selectByVisibleText("Mileage");
        WebElement newRow = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/ui-view/div/div[2]/label")));
        erp.click(By.);
        WebElement newReport = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/ui-view/div/table/tbody/tr/td")));
        String expected = VALID_NAME;
        String actual = newReport.getText();
        assertEquals(expected, actual);
    }

    @Test
    public void addLineItemAndValueToExpenseReportClickSubmitNavigatesToHomePage() {
        ExpenseReportPage erp = new ExpenseReportPage(driver);
        erp.sendKeys(By.id("inputExpenseReportName"), VALID_NAME);
        Select dropdown = new Select(driver.findElement(By.id("drpdwnvalue")));
        dropdown.selectByVisibleText("Mileage");
        WebElement newRow = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/ui-view/div/div[2]/label")));
        newRow.sendKeys(VALID_VALUE);
        driver.findElement(By.xpath("//button")).click();
        WebElement newReport = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/ui-view/div/table/tbody/tr/td"))); //Change the xpath once log in is figured out
        String expected = VALID_NAME;
        String actual = newReport.getText();
        assertEquals(expected, actual);
    }
}
