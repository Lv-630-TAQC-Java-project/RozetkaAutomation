package com.ss.ita.google.ui.elements;

import com.ss.ita.google.ui.locators.BaseLocator;
import org.openqa.selenium.WebDriver;

public class Button extends BaseWebElement {

    public Button(WebDriver driver, BaseLocator locator) {
        super(driver, locator);

    }

    public void clickButton() {
        this.webElement.click();
    }

}