package com.ss.ita.google.ui.pages.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner.driver;
import static java.lang.String.format;

public class WebElementUtil {

    public static String getColor(WebElement webElement) {
        return webElement.getCssValue("color");
    }

    public static void setColorViaJs(WebElement webElement, String color) {
        ((JavascriptExecutor) driver).executeScript(format("arguments[0].style.color='%s'", color), webElement);
    }

    public static void setAttribute(WebElement element, String attributeName, String value) {
        String script = "arguments[0].setAttribute(arguments[1], arguments[2]);";
        ((JavascriptExecutor) driver).executeScript(script, element, attributeName, value);
    }

    public static void removeAttribute(WebElement element, String attributeName) {
        String script = "arguments[0].removeAttribute(arguments[1], arguments[1])";
        ((JavascriptExecutor) driver).executeScript(script, element, attributeName);
    }

    public static void setVisibility(WebElement element, boolean isHidden){
        if (isHidden){
            setAttribute(element, "hidden", "true");
        }
        else {
            removeAttribute(element, "hidden");
        }
    }
}
