package com.ss.ita.google.ui.elements;

import com.ss.ita.google.ui.locators.BaseLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    public String getAttribute(String attribute){
        return webElement.getAttribute(attribute);
    }

    public void setAttribute(String attributeName, String value){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                webElement, attributeName, value);
    }

    public String getCssValue(String css){
        return webElement.getCssValue(css);
    }
}
