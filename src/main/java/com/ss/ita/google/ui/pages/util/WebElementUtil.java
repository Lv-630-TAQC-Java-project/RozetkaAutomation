package com.ss.ita.google.ui.pages.util;

import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class WebElementUtil {

    public static String getColor(WebElement webElement) {
        return webElement.getCssValue("color");
    }

    public static void setColorViaJs(WebElement webElement, String color) {
        executeJavaScript(format("arguments[0].style.color='%s'", color), webElement);
    }

    public static void setAttribute(WebElement element, String attributeName, String value) {
        String script = "arguments[0].setAttribute(arguments[1], arguments[2]);";
        executeJavaScript(script, element, attributeName, value);
    }

    public static void removeAttribute(WebElement element, String attributeName) {
        String script = "arguments[0].removeAttribute(arguments[1], arguments[1])";
        executeJavaScript(script, element, attributeName);
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
