package com.ss.ita.google.ui.elements;

import com.ss.ita.google.ui.locators.BaseLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Link extends BaseWebElement {
    public Link(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }

    public Link(WebElement element) {
        super(element);
    }

    public void click() {
        this.webElement.click();
    }

    public String getText(){
        return webElement.getText();
    }
}
