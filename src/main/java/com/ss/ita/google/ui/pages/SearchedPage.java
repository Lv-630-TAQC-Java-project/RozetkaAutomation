package com.ss.ita.google.ui.pages;

import org.openqa.selenium.By;
import static com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner.driver;

public class SearchedPage {

    public String getUrlPage() {
        return driver.getCurrentUrl();
    }
}
