package com.ss.ita.rozetka.ui.runner;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Configuration.browser;

public class TestRunner {

    @BeforeClass
    protected void setBrowser() {
        browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }
}
