package com.crm.qa.base;

import com.crm.qa.utils.ProjectConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    FileInputStream fis;
    public static Properties prop;
    public static WebDriver driver;

    public TestBase(){

// read properties from property file

         prop=new Properties();

        try {
            fis = new FileInputStream("C:\\Users\\pashi\\Documents\\Selenium\\POMTestNG_Hybrid Framework\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initializeBroser(){

        String browserName=prop.getProperty("brwosername");
        if(browserName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\pashi\\Downloads\\chromedriver_win32\\chromedriver.exe");
              ChromeOptions options = new ChromeOptions();
            ChromeOptions chromeOptions = options.addArguments("--disable-extensions");
            driver = new ChromeDriver(chromeOptions);

        }
        else
            System.out.println("Brwoser is not available");

        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(ProjectConstants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(ProjectConstants.PAGELOAD_TIMEOUT,TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

        //naviaget to url
        String url=prop.getProperty("url");
        driver.get(url);

    }
}
