package com.ss.ita.rozetka.ui.pages.components;

import com.ss.ita.rozetka.ui.pages.Header;

import static com.codeborne.selenide.Selenide.$x;

public class LeftSideMenu {

    public Header closeMenu(){
        $x("//button[@class='side-menu__close']").click();
        return new Header();
    }
}
