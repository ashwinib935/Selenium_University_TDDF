package com.univercity.qa.testcases;

import com.univercity.qa.base.TestBase;
import com.univercity.qa.pages.HomePage;
import com.univercity.qa.pages.LoginPage;
import com.univercity.qa.pages.ProfessionalExperiencePage;
import com.univercity.qa.pages.ReferencesPage;
import com.univercity.qa.utill.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProfessionalExperiencePageTest extends TestBase {

    LoginPage loginPage;
    ProfessionalExperiencePage professionalExperiencePage;

    HomePage homePage;

    String sheetName= "professionalDetails";
    public ProfessionalExperiencePageTest(){
        super();
    }

    @BeforeMethod
    public void startUp() {
        initialization();
        loginPage = new LoginPage();
        professionalExperiencePage = new ProfessionalExperiencePage();
      homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));

    }

    @DataProvider
    public Object[][] getPersonalInfoTestData(){
        Object data[][] =  TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 1,dataProvider ="getPersonalInfoTestData" )
    public void fillProfessionalExperienceDetail(String employerName,String street,String city,String state,String zip,String country,String position,String startDate) throws InterruptedException {
        Thread.sleep(3000);
       professionalExperiencePage.fillProfessionalInfo(employerName,street,city,state,zip,country,position,startDate);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
