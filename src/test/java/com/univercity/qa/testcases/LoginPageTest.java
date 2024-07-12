package com.univercity.qa.testcases;

import com.univercity.qa.base.TestBase;
import com.univercity.qa.pages.HomePage;
import com.univercity.qa.pages.LoginPage;
import com.univercity.qa.utill.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    private static final Logger log = Logger.getLogger(LoginPageTest.class);

    public LoginPageTest(){
        super();
    }



    @BeforeMethod
    public void setup(){
        initialization();
        log.info("Initialization is done");
        loginPage = new LoginPage();
    }

@Test
    public void loginTest()  {
      homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        log.info("login page");
    }

    @AfterMethod
    public void tearDown(){
       driver.quit();
    }

}
