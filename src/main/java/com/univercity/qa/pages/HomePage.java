package com.univercity.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.univercity.qa.base.TestBase.driver;

public class HomePage {


    @FindBy(xpath = "//div[normalize-space()='Personal Information']")
    WebElement personalInfoLink;

    @FindBy(xpath = "//div[normalize-space()='Education History']")
    WebElement educationHistoryLink;

    @FindBy(xpath = "//div[normalize-space()='Professional Experience']")
    WebElement professionalExpLink;

    @FindBy(xpath = "//div[normalize-space()='References']")
    WebElement referencesLink;

    @FindBy(xpath = "//div[normalize-space()='Personal Statement']")
    WebElement personalStatementLink;


    @FindBy(xpath = "//div[normalize-space()='Refer a Friend']")
    WebElement referAFriendLink;
    WebDriverWait wait;
    public HomePage(){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public PersonalInformationPage clickOnPersonalInfo(){
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
          personalInfoLink.click();
          return new PersonalInformationPage();
    }

    public EducationInfoPage clickOnEducationInfo(){
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        educationHistoryLink.click();
        return new EducationInfoPage();
    }

    public ProfessionalExperiencePage clickOnProfessionalExp(){
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        professionalExpLink.click();
        return new ProfessionalExperiencePage();
    }

    public ReferencesPage clickOnReferences(){
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        referencesLink.click();
        return new ReferencesPage();
    }

    public PersonalStatementPage clickOnPersonalStatement(){
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        personalStatementLink.click();
        return new PersonalStatementPage();
    }

    public ReferAFriendPage clickOnReferAFriend(){
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        referAFriendLink.click();
        return new ReferAFriendPage();
    }
}
