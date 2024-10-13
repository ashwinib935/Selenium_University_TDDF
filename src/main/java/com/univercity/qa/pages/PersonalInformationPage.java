package com.univercity.qa.pages;

import com.univercity.qa.utill.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.univercity.qa.base.TestBase.driver;

public class PersonalInformationPage {

    @FindBy(xpath = "//input[@id='a1q0e000005HbZTAA0-29']")
    WebElement degree;

    @FindBy(xpath = "//select[@id='select-term-picklist-28']")
    WebElement academicTerm;


    @FindBy(xpath = "//input[@name='Nickname__c']")
    WebElement pFName;

    @FindBy(xpath = "//input[@name='Date_of_Birth__c']")
    WebElement bDate;

    @FindBy(xpath = "//input[@name='Address_Line_1__c']")
    WebElement address1;

    @FindBy(xpath = "//input[@name='City__c']")
    WebElement city;

    @FindBy(xpath = "//input[@name='State_Province__c']")
    WebElement state;

    @FindBy(xpath = "//input[@name='Zip_Postal_Code__c']")
    WebElement zipCode;

    @FindBy(xpath = "//select[@name='Country__c']")
    WebElement country;

    @FindBy(xpath = "//select[@name='Citizenship_Status__c']")
    WebElement citizenship_status;

    @FindBy(xpath = "//input[@id='Yes-99']")
    WebElement hispanic_Latino_Yes;

    @FindBy(xpath = "//input[@id='No-99']")
    WebElement hispanic_Latino_No;

    @FindBy(xpath = "//div[@class='btn__wrap']//button")
    WebElement continueBtn;

    public PersonalInformationPage() {
        PageFactory.initElements(driver, this);

    }

    public void fillPersonlInfo(String selectedDegree, String selectedAcademic, String preferedFirstName, String birthDate, String addr1,
                                String selectedCity, String selectedState, String selectedZipCode, String selectedCountry, String selectedCitizenshipStatus, String iS_hispanicOrLatino) throws InterruptedException {

        List<WebElement> degreeList = driver.findElements(By.xpath("//ul[@class='list-container']//li"));
        System.out.println("Degree size" + degreeList.size());
        Thread.sleep(2000);
        for (int i = 0; i < degreeList.size(); i++) {
            if (degreeList.get(i).getText().equals(selectedDegree)) {
                degreeList.get(i).click();
                break;
            }
        }

        Thread.sleep(3000);
        Select academic = new Select(academicTerm);
        academic.selectByVisibleText(selectedAcademic);

        pFName.sendKeys(preferedFirstName);
        bDate.sendKeys(birthDate);
        address1.sendKeys(addr1);
        city.sendKeys(selectedCity);
        state.sendKeys(selectedState);
        zipCode.sendKeys(selectedZipCode);

        Select selectCountry = new Select(country);
        selectCountry.selectByVisibleText(selectedCountry);

        Select citizen = new Select(citizenship_status);
        citizen.selectByVisibleText(selectedCitizenshipStatus);


        if (iS_hispanicOrLatino.equals("Yes")) {
           // new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(hispanic_Latino_Yes)).click();
            ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", hispanic_Latino_Yes);

        } else if (iS_hispanicOrLatino.equals("No")) {
           // new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(hispanic_Latino_No)).click();
            ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", hispanic_Latino_No);

        }

        continueBtn.click();



    }


}
