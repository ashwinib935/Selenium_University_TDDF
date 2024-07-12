package com.univercity.qa.testcases;

import com.univercity.qa.base.TestBase;
import com.univercity.qa.pages.HomePage;
import com.univercity.qa.pages.LoginPage;
import com.univercity.qa.pages.PersonalStatementPage;
import com.univercity.qa.pages.ReferencesPage;
import com.univercity.qa.utill.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReferencesPageTest extends TestBase {

    LoginPage loginPage;
    ReferencesPage referencesPage;
    HomePage homePage;

    String sheetName ="referenceDetails";
    public  ReferencesPageTest(){
        super();
    }

    @BeforeMethod
    public void startUp(){
        initialization();
        loginPage = new LoginPage();
        referencesPage = new ReferencesPage();
       homePage = loginPage.login(prop.getProperty("email"),prop.getProperty("password"));

    }
    @DataProvider
    public Object[][] getPersonalInfoTestData(){
        Object data[][] =  TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 1,dataProvider ="getPersonalInfoTestData")
    public void fillReferencesDetailsTest(String refer1FName,String refer1LName,String refer1Title,String refer1Organization,String refer1email,String refer1Phone,
                                          String refer2FName,String refer2LName,String refer2Title,String refer2Organization,String refer2email,String refer2Phone) throws InterruptedException {

      referencesPage.fillReferencesDetails(refer1FName,refer1LName,refer1Title,refer1Organization,refer1email,refer1Phone,
                refer2FName,refer2LName,refer2Title,refer2Organization,refer2email,refer2Phone);

    }

    @AfterMethod
    public void tearDown(){
       driver.quit();
    }

}
