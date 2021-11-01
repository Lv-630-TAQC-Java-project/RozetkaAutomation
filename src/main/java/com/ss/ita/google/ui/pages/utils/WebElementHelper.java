package com.ss.ita.google.ui.pages.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner.driver;

public class WebElementHelper {
    private WebElementHelper() {
    }

    public static JavascriptExecutor getExecutorFromDriver() {
        return (JavascriptExecutor) driver;
    }

    public static void changeAttributeValue(WebElement element, String attributeName, String value) {
        String script = "arguments[0].setAttribute(arguments[1], arguments[2]);";
        getExecutorFromDriver().executeScript(script, driver, element, attributeName, value);
    }
}
