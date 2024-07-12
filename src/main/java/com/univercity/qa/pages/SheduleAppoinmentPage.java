package com.univercity.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.univercity.qa.base.TestBase.driver;

public class SheduleAppoinmentPage {

    @FindBy(xpath = "//div[@class='widget-box progress-tracker']//button[4]")
    WebElement sheduleBtn;

    @FindBy(xpath = "//select[@id='webScheduler:webschedform:reason1_1']")
    WebElement howCanWeHelpYou;

    @FindBy(xpath = "//button[@id='oppRqstBtn']")
    WebElement oppRequestBtn;

    @FindBy(xpath = "//select[@name='webScheduler:webschedform:timezonelist1']")
    WebElement selectTimezone;

    public SheduleAppoinmentPage() {
        PageFactory.initElements(driver, this);
    }

    public void sheduleAppoinment() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        sheduleBtn.click();

        Select select =new Select(howCanWeHelpYou);
        select.selectByVisibleText("Application Question");

//        JavascriptExecutor js = (JavascriptExecutor)driver;
//
//        // Call the JavascriptExecutor methods
//        js.executeScript("arguments[0].click();", oppRequestBtn);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(oppRequestBtn)).click();
        //oppRequestBtn.click();
        System.out.println("click !!");
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        Select select1 = new Select(selectTimezone);
        select1.selectByVisibleText("Mountain Daylight Time (Denver)");



    }

}

