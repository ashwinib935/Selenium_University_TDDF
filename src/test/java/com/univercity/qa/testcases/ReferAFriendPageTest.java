package com.univercity.qa.testcases;

import com.univercity.qa.base.TestBase;
import com.univercity.qa.pages.HomePage;
import com.univercity.qa.pages.LoginPage;
import com.univercity.qa.pages.ReferAFriendPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReferAFriendPageTest extends TestBase {
    LoginPage loginPage;
    ReferAFriendPage referAFriendPage;
    HomePage homePage;
    public  ReferAFriendPageTest(){
        super();
    }

    @BeforeMethod
    public void startUp(){
        initialization();
        loginPage =new LoginPage();
        referAFriendPage =new ReferAFriendPage();
      homePage =loginPage.login(prop.getProperty("email"), prop.getProperty("password"));

    }

    @Test(priority = 1)
    public void fillReferAFriendTest() throws InterruptedException {
        referAFriendPage.fillReferAFriend();
    }

    @AfterMethod
    public void tearDown(){
       driver.quit();
    }
}
