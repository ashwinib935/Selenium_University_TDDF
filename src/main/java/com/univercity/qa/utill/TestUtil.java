package com.univercity.qa.utill;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.checkerframework.checker.formatter.qual.InvalidFormat;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InvalidPropertiesFormatException;

import static com.univercity.qa.base.TestBase.driver;

public class TestUtil {
    public static long PAGE_LOAD_TIMEOUT =20;
    public static long IMPLICIT_WAIT = 10;
    public static String TESTDATA_SHEET_PATH = "I:\\Ashwini_Testing\\University\\src\\main\\java\\com\\univercity\\qa\\testdata\\univercity.xlsx";

    static Workbook book;
    static Sheet sheet;
    public static ExtentReports extent;
    public static ExtentTest extentTest;
    public static Object[][] getTestData(String sheetName){
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        }catch (InvalidPropertiesFormatException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }

        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        System.out.println(sheet.getLastRowNum()+"----------"+sheet.getRow(0).getLastCellNum());

        for (int i=0;i<sheet.getLastRowNum();i++){
            for(int k=0;k<sheet.getRow(0).getLastCellNum();k++){
                data[i][k] = sheet.getRow(i+1).getCell(k).toString();
            }
        }
        return  data;
    }

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }
    public static String takeScreenshotForFaillTest(WebDriver driver, String screenShortName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots"
        // under src folder
        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenShortName + dateName
                + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }
}
