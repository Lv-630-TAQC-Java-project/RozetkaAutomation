package com.ss.ita.rozetka.ui.testUtils;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Configuration.browser;

@Listeners(TestListener.class)
public class TestRunner {

    @BeforeClass
    protected void setBrowser() {
        browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }
}
