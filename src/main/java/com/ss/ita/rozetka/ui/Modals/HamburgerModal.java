package com.ss.ita.rozetka.ui.Modals;

import com.ss.ita.rozetka.ui.elements.Header;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class HamburgerModal {

    @Step("SideMenuModal: close side menu modal")
    public Header closeHamburgerModal() {
        $x("//button[@class='side-menu__close']").click();
        return new Header();
    }
}
