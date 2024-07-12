//package com.univercity.qa.testcases;
//
//import com.univercity.qa.base.TestBase;
//import com.univercity.qa.pages.HomePage;
//import com.univercity.qa.pages.LoginPage;
//import com.univercity.qa.pages.RegisterPage;
//import com.univercity.qa.utill.TestUtil;
//import org.python.antlr.ast.Str;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//public class RegisterPageTest extends TestBase {
//    RegisterPage registerPage;
//    String sheetName = "register";
//
//    public RegisterPageTest() {
//        super();
//    }
//
//    @BeforeMethod
//    public void setUp() {
//        initialization();
//        registerPage = new RegisterPage();
//
//    }
//
//    @Test
//    public void registerPageTitleTest() {
//        String title = registerPage.verifyRegisterTitle();
//        System.out.println("Title:" + title);
//        Assert.assertEquals(title, "Saint Mary's University of Minnesota");
//    }
//
//    @Test
//    public void startApplicationTest(){
//        registerPage.startApplication();
//    }
//
//
//    @DataProvider
//    public Object[][] getUnivercityTestData(){
//        Object data[][] =  TestUtil.getTestData(sheetName);
//        return data;
//    }
//
// @Test(dataProvider = "getUnivercityTestData")
// public void registrationTest(String fname, String lname, String degree, String academic,String phone,String email,String country,String password,String c_password) throws InterruptedException {
//     registerPage.startApplication();
//        registerPage.registration(fname,lname,degree,academic,phone,email,country,password,c_password);
// }
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
//}
