package com.ss.ita.runner;

import com.ss.ita.PropertiesProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;


public class TestRunner {
    protected static WebDriver driver;
    protected SoftAssert softAssert;
    PropertiesProvider propertiesProvider = new PropertiesProvider();

    @BeforeClass
    protected void getDriver() {
        switch (propertiesProvider.getBrowser()) {
            case "chrome": {
                System.setProperty("webdriver.chrome.driver", propertiesProvider.getChromeBrowser());
                driver = new ChromeDriver();
                break;
            }
            case "firefox": {
                System.setProperty("webdriver.gecko.driver", propertiesProvider.getFirefoxBrowser());
                driver = new FirefoxDriver();
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid browser");
            }
        }
        driver.manage().window().maximize();
        driver.get(propertiesProvider.getBaseUrl());
    }

    @AfterClass
    protected void quitDriver() {
        if (driver != null) driver.quit();
    }

    @BeforeMethod
    protected void setUp() {
        softAssert = new SoftAssert();
    }

}