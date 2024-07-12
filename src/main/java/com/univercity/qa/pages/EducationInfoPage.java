package com.univercity.qa.pages;

import com.univercity.qa.utill.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.univercity.qa.base.TestBase.driver;

public class EducationInfoPage {


    @FindBy(xpath="//input[@class='element__input']")
    WebElement collegeOrUnivercityName;

    @FindBy(xpath = "//input[@name='College_Start_Date__c']")
    WebElement dateBegun;

    @FindBy(xpath = "//input[@name='College_End_Date__c']")
    WebElement dateEnded;

    @FindBy(xpath = "//input[@name='College_Major__c']")
    WebElement majorOrFieldOfStudy;

    @FindBy(xpath = "//div[@class='save-remove-btn__wrap']//c-custom-button[@class='save-btn']//button")
    WebElement saveBtn;


    @FindBy(xpath = "//div[@class='btn__wrap']//button")
    WebElement continueBtn;

    public EducationInfoPage(){

        PageFactory.initElements(driver,this);

    }


    public void fillEducationInformation(String collegeorUnivercityName,String dateOfBegun,String dateOfEnd,String majorFieldOfStudy) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        collegeOrUnivercityName.sendKeys("4");
        List<WebElement> collegeOrUnivercityList = driver.findElements(By.xpath("//ul[contains(@class,'dropdown-list')]//li"));
        System.out.println("college list"+collegeOrUnivercityList);
        for(int i=0;i<collegeOrUnivercityList.size();i++){
            if(collegeOrUnivercityList.get(i).getText().equals(collegeorUnivercityName)){
                collegeOrUnivercityList.get(i).click();
                break;
            }
        }
        Thread.sleep(2000);
        dateBegun.sendKeys(dateOfBegun);
        dateEnded.sendKeys(dateOfEnd);
        majorOrFieldOfStudy.sendKeys(majorFieldOfStudy);
        continueBtn.click();


    }


}
