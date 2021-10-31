package com.ss.ita.google.ui.pages.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementHelper {
    private WebElementHelper() {
    }

    public static void executeScriptForWebElement(String script, WebDriver driver, Object... args) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(script, args);
    }

    public static void changeAttributeValue(WebDriver driver, WebElement element, String attributeName, String value) {
        String script = "arguments[0].setAttribute(arguments[1], arguments[2]);";
        executeScriptForWebElement(script, driver, element, attributeName, value);
    }
}
