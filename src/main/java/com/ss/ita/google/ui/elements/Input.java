package com.ss.ita.google.ui.elements;

import com.ss.ita.google.ui.locators.BaseLocator;
import org.openqa.selenium.WebDriver;

public class Input extends BaseWebElement {

    public Input(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }

    public void clickInput() {
        this.webElement.click();
    }

    public void clearInput() {
        this.webElement.clear();
    }

    public void sendKeys(String txt) {
        this.webElement.sendKeys(txt);
    }

}