package com.univercity.qa.pages;

import com.univercity.qa.utill.JavaScriptExecuterUtil;
import com.univercity.qa.utill.TestUtil;
import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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

    WebDriverWait wait;
    public LoginPage() {
        PageFactory.initElements(driver, this);
        homePage = new HomePage();
       wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public HomePage login(String emailId, String pwd) {

        JavaScriptExecuterUtil.scrollIntoView(loginBtn, driver);
        email.sendKeys(emailId);

        password.sendKeys(pwd);

        loginBtn.click();
        return homePage;


    }

}
