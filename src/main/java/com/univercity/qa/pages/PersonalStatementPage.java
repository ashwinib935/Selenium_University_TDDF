package com.univercity.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static com.univercity.qa.base.TestBase.driver;

public class PersonalStatementPage {

    @FindBy(xpath = "//input[@class='uploadbuttonid']")
    WebElement uploadRadiobtn;

    @FindBy(xpath = "//c-custom-button[@class='choose-file-btn']//button")
    WebElement selectFileBtn;

    @FindBy(xpath = "//input[@type='file' and @class='device-input' ]")
    WebElement inputFile;

    @FindBy(xpath = "//c-custom-button[@class='file-upload__btn']//button")
    WebElement upload;
    @FindBy(xpath = "//div[@class='btn__wrap']//button")
    WebElement continueBtn;

    public PersonalStatementPage(){
        PageFactory.initElements(driver,this);

    }

    public void fillPersonalStatement() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", uploadRadiobtn);

        selectFileBtn.click();
        Thread.sleep(2000);
        inputFile.sendKeys("C:\\Users\\WIN 10\\Desktop\\JS_Questions.docx");
        Thread.sleep(2000);
        upload.click();
        Thread.sleep(5000);
        continueBtn.click();

    }

}
