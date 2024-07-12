package com.univercity.qa.testcases;

import com.univercity.qa.base.TestBase;
import com.univercity.qa.pages.EducationInfoPage;
import com.univercity.qa.pages.HomePage;
import com.univercity.qa.pages.LoginPage;
import com.univercity.qa.pages.ProfessionalExperiencePage;
import com.univercity.qa.utill.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EducationaInformationPageTest extends TestBase {
    LoginPage loginPage;
    EducationInfoPage educationInfoPage;
    HomePage homePage;
    String sheetName = "educationalDetails";

    public EducationaInformationPageTest(){
        super();
    }

    @BeforeMethod
    public void startUp(){
        initialization();
        loginPage = new LoginPage();
        educationInfoPage = new EducationInfoPage();

       homePage = loginPage.login(prop.getProperty("email"),prop.getProperty("password"));

    }
    @DataProvider
    public Object[][] getPersonalInfoTestData(){
        Object data[][] =  TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 1,dataProvider ="getPersonalInfoTestData")
    public  void fillEducationInformationTest(String collegeorUnivercityName,String dateOfBegun,String dateOfEnd,String majorFieldOfStudy) throws InterruptedException {
        Thread.sleep(3000);
       educationInfoPage.fillEducationInformation(collegeorUnivercityName,dateOfBegun,dateOfEnd,majorFieldOfStudy);
    }

    @AfterMethod
    public void tearDown(){
       driver.quit();
    }


}
