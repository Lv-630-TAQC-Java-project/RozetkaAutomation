package com.ss.ita.google.ui.pages.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner.driver;

public class HelperClass {

        public static void executeScriptForWebElementsColor(WebElement webElement) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].style.color='lightpink'", webElement);
        }

}
