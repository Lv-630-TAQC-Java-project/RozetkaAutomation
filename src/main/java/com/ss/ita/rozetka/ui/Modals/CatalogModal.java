package com.ss.ita.rozetka.ui.Modals;

import com.ss.ita.rozetka.ui.pages.*;

import static com.codeborne.selenide.Selenide.*;

public class CatalogModal extends Header {

    public boolean isCatalogModalDisplayed(){
    return $(".menu-wrapper").isDisplayed();
    }
}
