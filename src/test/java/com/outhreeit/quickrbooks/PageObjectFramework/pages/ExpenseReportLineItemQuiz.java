package com.outhreeit.quickrbooks.PageObjectFramework.Pages;

import com.outhreeit.quickrbooks.SeleniumFramework.Pages.ExpenseReportPage;
import com.outhreeit.quickrbooks.SeleniumFramework.Pages.HomePage;
import com.outhreeit.quickrbooks.SeleniumFramework.TestPageObject;
import org.apache.tomcat.jni.Thread;
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
    private final String VALID_NAME = "Expense Report Test Name";



    @Test
    public void addALineItemToTheExpenseReportSuccessfullyTest(){
        ExpenseReportPage erp = new ExpenseReportPage(driver);
        erp.sendKeys(By.id("inputExpenseReportName"), VALID_NAME);
        Select dropdown = new Select(erp.find(By.id("drpdwnvalue")));
        dropdown.selectByVisibleText("Mileage");
        String actual = erp.find(By.xpath("/html/body/div/ui-view/div/div[2]/label")).getText();
        String expected = "Mileage";
        assertEquals(expected, actual);
    }

    @Test
    public void addALineItemThatAlreadyExistsToExpenseReportFailsTests(){
        ExpenseReportPage erp = new ExpenseReportPage(driver);
        erp.sendKeys(By.id("inputExpenseReportName"), VALID_NAME);
        int current = erp.findElements(By.xpath("/html/body/div/ui-view/div/div")).size();
        int expected = current+2;
        Select dropdown = new Select(erp.find(By.id("drpdwnvalue")));
        dropdown.selectByVisibleText("Mileage");
        erp.find(By.xpath("/html/body/div/ui-view/div/div[2]/label"));
        dropdown.selectByVisibleText("Lodging");
        erp.find(By.xpath("/html/body/div/ui-view/div/div[3]/label"));
        dropdown.selectByVisibleText("Mileage");
        int actual = erp.findElements(By.xpath("/html/body/div/ui-view/div/div")).size();
        assertEquals(expected, actual);
    }

    @Test
    public void addALineItemToExpenseReportClickSubmitNavigatesToHomePage(){
        HomePage homePage = new HomePage(driver);
        int expected = homePage.findElements(By.xpath("/html/body/div/ui-view/div/table/tbody/tr")).size()+1;
        homePage.find(By.linkText("Create")).click();
        homePage.find(By.linkText("Expense Report")).click();
        homePage.sendKeys(By.id("inputExpenseReportName"), VALID_NAME+"noValueWithLineItem");
        Select dropdown = new Select(homePage.find(By.id("drpdwnvalue")));
        dropdown.selectByVisibleText("Mileage");
        homePage.find(By.xpath("/html/body/div/ui-view/div/div[2]/label"));
        homePage.getButtonByText("Save").click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/ui-view/div/table/tbody/tr["+expected+"]")));
        int actual = homePage.findElements(By.xpath("/html/body/div/ui-view/div/table/tbody/tr")).size();
        assertEquals(expected, actual);
    }

    @Test
    public void addLineItemAndValueToExpenseReportClickSubmitNavigatesToHomePage() {
        HomePage homePage = new HomePage(driver);
        int expected = homePage.findElements(By.xpath("/html/body/div/ui-view/div/table/tbody/tr")).size()+1;
        homePage.find(By.linkText("Create")).click();
        homePage.find(By.linkText("Expense Report")).click();
        homePage.sendKeys(By.id("inputExpenseReportName"), VALID_NAME+"ValueWithLineItem");
        Select dropdown = new Select(homePage.find(By.id("drpdwnvalue")));
        dropdown.selectByVisibleText("Mileage");
        homePage.find(By.xpath("/html/body/div/ui-view/div/div[2]/input")).sendKeys(VALID_VALUE);
        homePage.getButtonByText("Save").click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/ui-view/div/table/tbody/tr["+expected+"]")));
        int actual = homePage.findElements(By.xpath("/html/body/div/ui-view/div/table/tbody/tr")).size();
        assertEquals(expected, actual);
    }
}
