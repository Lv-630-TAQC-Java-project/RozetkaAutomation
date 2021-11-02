package com.ss.ita.google.ui.pages.utils;

import org.openqa.selenium.WebElement;

public class Utils {
    public static String getWebElementColor(WebElement webElement) {
        return webElement.getCssValue("color");
    }


}
