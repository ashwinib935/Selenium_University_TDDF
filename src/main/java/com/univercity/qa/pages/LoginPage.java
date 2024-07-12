package com.univercity.qa.pages;

import com.univercity.qa.utill.JavaScriptExecuterUtil;
import com.univercity.qa.utill.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static com.univercity.qa.base.TestBase.driver;

public class LoginPage {

    @FindBy(xpath = "//input[@id='Email-9']")
    WebElement email;

    @FindBy(xpath = "//input[@id='Password-9']")
    WebElement password;

    @FindBy(xpath = "//div[@class='login-btn--wrapper']//button")
    WebElement loginBtn;
    HomePage homePage;


    public LoginPage() {
        PageFactory.initElements(driver, this);
        homePage = new HomePage();
    }

    public HomePage login(String emailId, String pwd) {

        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        JavaScriptExecuterUtil.scrollIntoView(loginBtn, driver);
        email.sendKeys(emailId);

        password.sendKeys(pwd);

        loginBtn.click();
        return homePage;


    }

}
