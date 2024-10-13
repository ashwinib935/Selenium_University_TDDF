package com.univercity.qa.pages;

import com.univercity.qa.utill.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;
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

    WebDriverWait wait;
    public ProfessionalExperiencePage(){
        wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);

    }

    public void fillProfessionalInfo(String employername,String streetAddress,String cityOfEmp,String state1,String zipCode,String selectedCountry,String positionOfEmp,String startdate) throws InterruptedException {
       wait.until(ExpectedConditions.visibilityOfElementLocated(uploadFileBtn));
        uploadFileBtn.click();

        inputFile.sendKeys("C:\\Users\\WIN 10\\Desktop\\JS_Questions.docx");
        upload.click();
        employerName.sendKeys(employername);
        street.sendKeys(streetAddress);
        city.sendKeys(cityOfEmp);
        state.sendKeys(state1);
        zip.sendKeys(zipCode);
        Select select= new Select(country);
        select.selectByVisibleText(selectedCountry);
        position.sendKeys(positionOfEmp);
        startDate.sendKeys(startdate);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", currentlyEmpHereCheckbox);
        saveBtn.click();
        continueBtn.click();


    }
}
