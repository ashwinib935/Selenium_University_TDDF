package com.univercity.qa.base;

import com.univercity.qa.utill.TestUtil;
import com.univercity.qa.utill.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_Driver;
    public static WebEventListener eventListener;

    public TestBase() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("I:\\Ashwini_Testing\\University\\src\\main\\java\\com\\univercity\\qa\\config\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\WIN 10\\Downloads\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\WIN 10\\Downloads\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        e_Driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_Driver.register(eventListener);
        driver = e_Driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

    }

}
