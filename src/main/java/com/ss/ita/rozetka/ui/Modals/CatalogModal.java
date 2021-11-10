package com.ss.ita.rozetka.ui.Modals;

import com.ss.ita.rozetka.ui.pages.*;

import static com.codeborne.selenide.Selenide.$x;

public class CatalogModal extends Header {

    public boolean isCatalogModalDisplayed(){
    return $x("/html/body/app-root/div/div/rz-header/header/div/div/rz-header-fat-menu/fat-menu/div/ul/li[6]/div").isDisplayed();
    //html/body/app-root/div/div/rz-header/header/div/div/rz-header-fat-menu/fat-menu/div/ul/li[6]/div
    }
}
