package com.ss.ita.rozetka.pageobject.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Configuration.browser;

@Listeners(TestListener.class)
public class TestRunner {

    @BeforeClass
    protected void setBrowser() {
        browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 120000;
    }

    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
