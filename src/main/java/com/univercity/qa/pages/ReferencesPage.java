package com.univercity.qa.pages;

import com.univercity.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.univercity.qa.base.TestBase.driver;

public class ReferencesPage {

    @FindBy(xpath ="//input[@name='Reference_First_Name__c']")
    WebElement ref1FName;
    @FindBy(xpath ="//input[@name='Reference_Last_Name__c']")
    WebElement ref1LName;
    @FindBy(xpath ="//input[@name='Reference_Position__c']" )
    WebElement ref1Title;
    @FindBy(xpath = "//input[@name='Reference_Company_Name__c']")
    WebElement ref1Organization;
    @FindBy(xpath = "//input[@name='Reference_Email__c']")
    WebElement ref1email;

    @FindBy(xpath="//div[@role='combobox' and @aria-controls='iti-0__country-listbox']")
    WebElement flag1select;

    @FindBy(xpath="//div[@role='combobox' and @aria-controls='iti-1__country-listbox']")
    WebElement flag2select;
    @FindBy(xpath ="//input[@name='Reference_Phone__c']" )
    WebElement ref1Telephone;
    @FindBy(xpath = "//input[@name='Section_A_First_Name__c']")
    WebElement ref2FName;
    @FindBy(xpath = "//input[@name='Referral_Name1__c']")
    WebElement ref2LName;
    @FindBy(xpath = "//input[@name='Reference_Title__c']")
    WebElement ref2Title;

    @FindBy(xpath = "//input[@name='Reference_Organization__c']")
    WebElement ref2Organization;

    @FindBy(xpath = "//input[@name='Referral_Email1__c']")
    WebElement ref2email;

    @FindBy(xpath = "//input[@name='Referral_Phone1__c']")
    WebElement ref2Telephone;

    @FindBy(xpath = "//div[@class='btn__wrap']//button")
    WebElement continueBtn;
    public ReferencesPage(){
        PageFactory.initElements(driver,this);

    }

    public void fillReferencesDetails(String refer1FName,String refer1LName,String refer1Title,String refer1Organization,String refer1email,String refer1Phone,
                                      String refer2FName,String refer2LName,String refer2Title,String refer2Organization,String refer2email,String refer2Phone) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);

        ref1FName.sendKeys(refer1FName);
        ref1LName.sendKeys(refer1LName);
        ref1Title.sendKeys(refer1Title);
        ref1Organization.sendKeys(refer1Organization);
        ref1email.sendKeys(refer1email);

        flag1select.click();
        Thread.sleep(5000);

        List<WebElement>flaglist1 = driver.findElements(By.xpath("//ul[@id='iti-0__country-listbox']//li"));
        System.out.println("Flag  list 1"+flaglist1.size());
        for (int i=0;i<flaglist1.size();i++){
            if(flaglist1.get(i).getText().contains("+91")){
                flaglist1.get(i).click();
                break;
            }
        }
        Thread.sleep(1000);
        JavascriptExecutor js1 = ((JavascriptExecutor) driver);
        js1.executeScript("arguments[0].value="+refer1Phone, ref1Telephone);

        Thread.sleep(5000);

        ref2FName.sendKeys(refer2FName);
        ref2LName.sendKeys(refer2LName);
        ref2Title.sendKeys(refer2Title);
        ref2Organization.sendKeys(refer2Organization);
        ref2email.sendKeys(refer2email);

        Thread.sleep(5000);

        flag2select.click();

        List<WebElement>flaglist2 = driver.findElements(By.xpath("//ul[@id='iti-1__country-listbox']//li"));
       System.out.println("Flag  list 2"+flaglist2.size());

        for (int i=0;i<flaglist2.size();i++){
            if(flaglist2.get(i).getText().contains("+91")){
                flaglist2.get(i).click();
                break;
            }
        }
        Thread.sleep(2000);
        JavascriptExecutor js2 = ((JavascriptExecutor) driver);
        js2.executeScript("arguments[0].value="+refer2Phone, ref2Telephone);

        continueBtn.click();


    }

}
