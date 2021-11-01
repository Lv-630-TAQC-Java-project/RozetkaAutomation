package com.ss.ita.google.ui.pages.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner.driver;
import static java.lang.String.format;

public class HelperClass {

    public static void executeScriptForWebElementsColor(String color, WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(format("arguments[0].style.color='%s'", color), webElement);
    }

}
