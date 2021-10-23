package com.ss.ita.google.ui.elements;

import com.ss.ita.google.ui.locators.BaseLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Label extends BaseWebElement {
    public Label(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }

    public Label(WebElement element, BaseLocator locator) {
        super(element, locator);
    }

    public Label(WebDriver driver, WebElement element, BaseLocator locator) {
        super(driver, element, locator);
    }

    public Label(WebElement element) {
        super(element);
    }

    public String getText() {
        return this.webElement.getText();
    }

    public void click() {
        this.webElement.click();
    }
}
