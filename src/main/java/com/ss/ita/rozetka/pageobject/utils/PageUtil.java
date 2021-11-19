package com.ss.ita.rozetka.pageobject.utils;

import static com.codeborne.selenide.WebDriverRunner.url;

public class PageUtil {
    public static String getCurrentUrl() {
        return url();
    }
}
