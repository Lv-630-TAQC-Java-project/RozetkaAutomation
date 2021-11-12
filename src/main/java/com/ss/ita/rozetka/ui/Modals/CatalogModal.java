package com.ss.ita.rozetka.ui.Modals;

import com.ss.ita.rozetka.ui.pages.HeaderPage;

import static com.codeborne.selenide.Selenide.*;

public class CatalogModal extends HeaderPage {

    public static boolean isCatalogModalDisplayed() {
        return $(".menu-wrapper").isDisplayed();
    }
}
