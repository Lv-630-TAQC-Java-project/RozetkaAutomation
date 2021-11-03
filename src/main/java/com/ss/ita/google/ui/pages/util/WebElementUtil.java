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
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(format("arguments[0].style.color='%s'", color), webElement);
    }
}
