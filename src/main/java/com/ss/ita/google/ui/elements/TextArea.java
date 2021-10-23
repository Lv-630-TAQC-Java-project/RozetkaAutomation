package com.ss.ita.google.ui.elements;

import com.ss.ita.google.ui.locators.BaseLocator;
import org.openqa.selenium.WebDriver;

public class TextArea extends BaseWebElement {

    public TextArea(WebDriver driver, BaseLocator locator) {
        super(driver, locator);

    }

    public void clearTextArea() {
        this.webElement.clear();
    }

    public void clickTextArea() {
        this.webElement.click();
    }

    public void sendKeysTextArea(String text) {
        this.webElement.sendKeys(text);
    }

    public String getBorderColor() {
        return this.webElement.getCssValue("border-color");
    }


}