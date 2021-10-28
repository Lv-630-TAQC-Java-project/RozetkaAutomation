package com.ss.ita.google.ui.pages.runnerAndProperties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TestRunner {
    public static WebDriver driver;


    @BeforeClass
    protected void getDriver() throws IOException {
        PropertiesProvider propertiesProvider = new PropertiesProvider();

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(propertiesProvider.getBaseUrl());
    }

    @AfterClass
    protected void quitDriver() {
        if (driver != null) driver.quit();
    }
}
