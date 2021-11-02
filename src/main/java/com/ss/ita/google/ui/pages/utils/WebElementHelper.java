package com.ss.ita.google.ui.pages.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner.driver;

public class WebElementHelper {
    private WebElementHelper() {
    }

    public static void setAttribute(WebElement element, String attributeName, String value) {
        String script = "arguments[0].setAttribute(arguments[1], arguments[2]);";
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(script, element, attributeName, value);
    }

    public static void removeAttribute(WebElement element, String attributeName) {
        String script = "arguments[0].removeAttribute(arguments[1], arguments[1])";
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(script, element, attributeName);
    }
}
