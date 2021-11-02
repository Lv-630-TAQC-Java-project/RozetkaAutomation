package com.ss.ita.google.ui.pages;

import static com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner.driver;

public class SearchedPage {

    public String getUrlPage() {
        return driver.getCurrentUrl();
    }
}
