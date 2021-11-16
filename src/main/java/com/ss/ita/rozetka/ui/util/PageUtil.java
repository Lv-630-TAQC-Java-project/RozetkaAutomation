package com.ss.ita.rozetka.ui.util;

import static com.codeborne.selenide.WebDriverRunner.url;

public class PageUtil {
    public static String getCurrentUrl() {
        return url();
    }
}
