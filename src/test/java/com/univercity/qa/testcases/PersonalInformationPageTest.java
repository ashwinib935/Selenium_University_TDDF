package com.univercity.qa.testcases;

import com.univercity.qa.base.TestBase;
import com.univercity.qa.pages.EducationInfoPage;
import com.univercity.qa.pages.HomePage;
import com.univercity.qa.pages.LoginPage;
import com.univercity.qa.pages.PersonalInformationPage;
import com.univercity.qa.utill.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PersonalInformationPageTest extends TestBase {
    PersonalInformationPage personalInfo;
    LoginPage loginPage;
    HomePage homePage;

    String sheetName2 = "personalInfo";

    public PersonalInformationPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        loginPage = new LoginPage();
        personalInfo = new PersonalInformationPage();


        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));

    }

    @DataProvider
    public Object[][] getPersonalInfoTestData() {
        Object data[][] = TestUtil.getTestData(sheetName2);
        return data;
    }


    @Test(priority = 1, dataProvider = "getPersonalInfoTestData")
    public void fillPersonalInfoTest(String degree, String academic, String preferedFirstName, String birthDate, String address1,
                                     String city, String state, String zipCode, String country, String citizenshipStatus, String iS_hispanicOrLatino) throws InterruptedException {

        Thread.sleep(3000);
        personalInfo.fillPersonlInfo(degree, academic, preferedFirstName, birthDate, address1, city, state, zipCode, country, citizenshipStatus, iS_hispanicOrLatino);


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
