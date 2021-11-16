package com.ss.ita.rozetka.ui.Modals;

import com.ss.ita.rozetka.ui.elements.Header;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
// class should be renamed by another PR to SideMenuModal
public class HamburgerModal {

    @Step("SideModalMenu: close side modal menu")
    public Header closeHamburgerModal() {
        $x("//button[@class='side-menu__close']").click();
        return new Header();
    }
}
