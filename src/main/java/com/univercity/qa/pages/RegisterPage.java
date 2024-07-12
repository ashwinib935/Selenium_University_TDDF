package com.univercity.qa.pages;

import com.univercity.qa.utill.JavaScriptExecuterUtil;
import com.univercity.qa.utill.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static com.univercity.qa.base.TestBase.driver;
import java.util.List;

public class RegisterPage {

@FindBy(xpath ="//div[@class='register-btn-wrapper']//button")
WebElement startApplicationbtn;

@FindBy(xpath ="//input[@id='First_Name__c-32']")
  WebElement firstName;
@FindBy(xpath ="//input[@id='Last_Name__c-34']")
WebElement lastName;

@FindBy(xpath ="//input[@id='a1q4y0000049HbnAAE-38']")
WebElement degree;

@FindBy(xpath = "//select[@id='select-term-picklist-37']")
WebElement academicTerm;

@FindBy(xpath = "//div[@class='iti__selected-flag']")
WebElement selectFlag;

@FindBy(xpath ="//input[@id='Mobile_Phone__c-40']")
WebElement phone;

@FindBy(xpath = "//input[@id='Email_Address__c-42']")
WebElement email;

@FindBy(xpath ="//select[@id='Country__c-45']")
WebElement country;

@FindBy(xpath = "//input[@id='password-48']")
WebElement password;

@FindBy(xpath = "//input[@id='confirmPassword-48']")
WebElement confirm_password;

@FindBy(xpath = "//div[@class='btn__wrap']//button")
WebElement continueBtn;

    public RegisterPage(){
        PageFactory.initElements(driver,this);
    }

    public  String verifyRegisterTitle(){
       return driver.getTitle();
    }


     public void startApplication(){
         JavaScriptExecuterUtil.scrollIntoView(startApplicationbtn,driver);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
         startApplicationbtn.click();
     }

     //
     public void registration(String fname, String lname, String deg, String academic_Term,String phoneNo,String email_Id,String selected_country,String pwd,String c_pwd) throws InterruptedException {
        Thread.sleep(2000);
         firstName.sendKeys(fname);
         Thread.sleep(2000);
         lastName.sendKeys(lname);
         Thread.sleep(2000);
         degree.sendKeys("Master");
     List<WebElement> degreeList = driver.findElements(By.xpath("//ul[@class='list-container']//li"));
         System.out.println("Degree size"+degreeList.size());
         Thread.sleep(2000);
         for (int i=0;i<degreeList.size();i++){
             if(degreeList.get(i).getText().equals(deg)){
                 degreeList.get(i).click();
                 break;
             }
         }

         Thread.sleep(3000);
         Select academic = new Select(academicTerm);
         academic.selectByVisibleText(academic_Term);

         Thread.sleep(2000);
         selectFlag.click();

         List<WebElement> flagList = driver.findElements(By.xpath("//ul[@id='iti-0__country-listbox']//li"));
         System.out.println("Size"+flagList.size());
         for(int i=0;i<flagList.size();i++){
             if(flagList.get(i).getText().contains("+91")){
                 flagList.get(i).click();

                 break;
             }
         }

        Thread.sleep(1000);
         JavascriptExecutor js = ((JavascriptExecutor) driver);
         js.executeScript("arguments[0].value="+phoneNo, phone);

         JavaScriptExecuterUtil.scrollIntoView(email,driver);
         Thread.sleep(3000);
         email.sendKeys(email_Id);
         Select selectedCountry = new Select(country);
         selectedCountry.selectByVisibleText(selected_country);
         Thread.sleep(3000);
         password.sendKeys(pwd);
         confirm_password.sendKeys(c_pwd);
         Thread.sleep(1000);
         continueBtn.click();

     }



}
