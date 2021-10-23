package com.ss.ita.google.ui.elements;

import com.ss.ita.google.ui.locators.BaseLocator;
import org.openqa.selenium.WebDriver;

public class Link extends BaseWebElement {
    public Link(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }

    public void click() {
        this.webElement.click();
    }
}
