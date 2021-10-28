package com.ss.ita.google.ui.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
