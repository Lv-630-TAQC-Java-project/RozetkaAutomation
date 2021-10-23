package com.ss.ita.google.ui.elements;

import com.ss.ita.google.ui.locators.BaseLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseWebElement {
    protected WebDriver driver;
    protected WebElement webElement;
    protected By path;

    public BaseWebElement(WebDriver driver, BaseLocator locator) {
        this.driver = driver;
        this.path = locator.getPath();
        this.webElement = this.driver.findElement(this.path);
    }

    public BaseWebElement(WebElement element, BaseLocator locator) {
        this.path = locator.getPath();
        this.webElement = element.findElement(this.path);

    }

    public BaseWebElement(WebDriver driver, WebElement element, BaseLocator locator) {
        this.driver = driver;
        this.path = locator.getPath();
        this.webElement = element.findElement(this.path);

    }

    public BaseWebElement(WebElement element) {
        this.webElement = element;
    }
}
