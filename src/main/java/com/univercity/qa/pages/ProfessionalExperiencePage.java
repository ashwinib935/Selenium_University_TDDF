package com.univercity.qa.pages;

import com.univercity.qa.utill.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static com.univercity.qa.base.TestBase.driver;

public class ProfessionalExperiencePage {


    @FindBy(xpath="//c-custom-button[@class='choose-file-btn']//button")
    WebElement uploadFileBtn;

    @FindBy(xpath = "//c-custom-button[contains(@class,'select-file-btn')]//button")
    WebElement selectFile;

    @FindBy(xpath = "//input[@type='file' and @class='device-input' ]")
    WebElement inputFile;

     @FindBy(xpath = "//c-custom-button[@class='file-upload__btn']//button")
     WebElement upload;

    @FindBy(xpath = "//input[@name='Company_Name__c']")
    WebElement employerName;

    @FindBy(xpath = "//input[@name='Address_1__c']")
    WebElement street;

    @FindBy(xpath = "//input[@name='City__c']")
    WebElement city;

    @FindBy(xpath = "//input[@name='State__c']")
    WebElement state;

    @FindBy(xpath = "//input[@name='Postal_Code__c']")
    WebElement zip;

    @FindBy(xpath = "//select[@name='ProfessionExp_Country__c']")
    WebElement country;

    @FindBy(xpath = "//input[@name='Position__c']")
    WebElement position;


    @FindBy(xpath = "//input[@name='Dates_of_Employment_Start__c']")
    WebElement startDate;

//    @FindBy(xpath = "//input[@name='Dates_of_Employment_End__c']")
//    WebElement endDate;

    @FindBy(xpath = "//input[@type='checkbox' and @name='Current_Employer__c']")
    WebElement currentlyEmpHereCheckbox;

    @FindBy(xpath = "//div[@class='save-remove-btn__wrap']//c-custom-button[@class='save-btn']//button")
    WebElement saveBtn;

    @FindBy(xpath = "//div[@class='btn__wrap']//button")
    WebElement continueBtn;

    public ProfessionalExperiencePage(){
        PageFactory.initElements(driver,this);

    }

    public void fillProfessionalInfo(String employername,String streetAddress,String cityOfEmp,String state1,String zipCode,String selectedCountry,String positionOfEmp,String startdate) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
//
        uploadFileBtn.click();
        Thread.sleep(2000);

        inputFile.sendKeys("C:\\Users\\WIN 10\\Desktop\\JS_Questions.docx");
        upload.click();

        Thread.sleep(5000);
        employerName.sendKeys(employername);
        Thread.sleep(2000);
        street.sendKeys(streetAddress);

        city.sendKeys(cityOfEmp);
        state.sendKeys(state1);
        zip.sendKeys(zipCode);
        Thread.sleep(2000);
        Select select= new Select(country);
        select.selectByVisibleText(selectedCountry);
        Thread.sleep(2000);
        position.sendKeys(positionOfEmp);
        Thread.sleep(2000);
        startDate.sendKeys(startdate);
        Thread.sleep(2000);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", currentlyEmpHereCheckbox);

        Thread.sleep(2000);
        saveBtn.click();
        Thread.sleep(5000);
        continueBtn.click();


    }
}
