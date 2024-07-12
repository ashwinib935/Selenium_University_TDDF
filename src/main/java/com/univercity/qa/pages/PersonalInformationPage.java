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


    @FindBy(xpath = "//input[@id='Nickname__c-38']")
    WebElement pFName;

    @FindBy(xpath = "//input[@id='Date_of_Birth__c-51']")
    WebElement bDate;

    @FindBy(xpath = "//input[@id='Address_Line_1__c-58']")
    WebElement address1;

    @FindBy(xpath = "//input[@id='City__c-62']")
    WebElement city;

    @FindBy(xpath = "//input[@id='State_Province__c-63']")
    WebElement state;

    @FindBy(xpath = "//input[@id='Zip_Postal_Code__c-64']")
    WebElement zipCode;

    @FindBy(xpath = "//select[@id='Country__c-67']")
    WebElement country;

    @FindBy(xpath = "//select[@id='Citizenship_Status__c-86']")
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

        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        Thread.sleep(5000);
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
