package com.ss.ita.rozetka.pageobject.utils;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.url;

public class PageUtil {
    public static String getCurrentUrl() {
        return url();
    }

    public static boolean isElementVisible(String elementXPath) {
        try {
            return $x(elementXPath)
                    .should(Condition.exist)
                    .is(Condition.visible);
        } catch (AssertionError exception) {
            return false;
        }
    }
}
