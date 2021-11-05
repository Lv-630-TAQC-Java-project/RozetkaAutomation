package com.ss.ita.google.ui.pages.runnerAndProperties;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

public class TestRunner {

    @BeforeClass
    protected void setBrowser() {
        browser = "chrome";
        Configuration.browserSize = "1920x1080";
        open("https://google.com");
    }
}
