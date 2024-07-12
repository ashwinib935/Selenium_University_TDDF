package com.univercity.qa.testcases;

import com.univercity.qa.base.TestBase;
import com.univercity.qa.pages.HomePage;
import com.univercity.qa.pages.LoginPage;
import com.univercity.qa.pages.PersonalStatementPage;
import com.univercity.qa.pages.ReferAFriendPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonalStatementPageTest extends TestBase {

    LoginPage loginPage;
    PersonalStatementPage personalStatementPage;
    HomePage homePage;

    public PersonalStatementPageTest(){
        super();
    }

    @BeforeMethod
    public void startUp(){
        initialization();
        loginPage = new LoginPage();
        personalStatementPage =new PersonalStatementPage();

        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void fillPersonalStatementDetailsTest() throws InterruptedException {
     personalStatementPage.fillPersonalStatement();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
