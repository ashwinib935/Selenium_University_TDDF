//package com.univercity.qa.testcases;
//
//import com.univercity.qa.base.TestBase;
//import com.univercity.qa.pages.LoginPage;
//import com.univercity.qa.pages.SheduleAppoinmentPage;
//import org.apache.log4j.Logger;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class SheduleAppoinmentPageTest extends TestBase {
//
//    LoginPage loginPage;
//    SheduleAppoinmentPage sheduleAppoinmentPage;
//    public SheduleAppoinmentPageTest(){
//        super();
//    }
//    private static final Logger log = Logger.getLogger(SheduleAppoinmentPageTest.class);
//    @BeforeMethod
//    public void startUp(){
//        initialization();
//        loginPage = new LoginPage();
//        sheduleAppoinmentPage = new SheduleAppoinmentPage();
//        sheduleAppoinmentPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
//      log.info("Initialization from shedule appoinment");
//
//    }
//
//    @Test
//    public void sheduleAppoinmentTest() throws InterruptedException {
//        sheduleAppoinmentPage.sheduleAppoinment();
//    }
//
//    @AfterMethod
//    public void tearDown(){
//       // driver.quit();
//    }
//
//}
