package com.univercity.qa.testcases;

import com.univercity.qa.base.TestBase;
import com.univercity.qa.pages.HomePage;
import com.univercity.qa.pages.LoginPage;
import com.univercity.qa.pages.PersonalInformationPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));

    }
      @Test(priority = 1)
      public void clickOnPersonalInfoTest(){
        homePage.clickOnPersonalInfo();
      }

    @Test(priority = 2)
    public void clickOnEducationInfoTest(){
        homePage.clickOnEducationInfo();
    }

    @Test(priority = 3)
    public void clickOnProfessionalExpTest(){
        homePage.clickOnProfessionalExp();
    }
    @Test(priority = 4)
    public void clickOnReferencesTest(){
        homePage.clickOnReferences();
    }
    @Test(priority = 5)
    public void clickOnPersonalStatementTest(){
        homePage.clickOnPersonalStatement();
    }
    @Test(priority = 6)
    public void clickOnReferAFriendTest(){
        homePage.clickOnReferAFriend();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
