package com.ss.ita.rozetka.ui.modals;

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

    @Step("SideModalMenu: open change town modal")
    public ChangeTownModal openChangeTownModal() {
        $x("//button[contains(@class, 'city-toggle')]").click();
        return new ChangeTownModal();
    }

    @Step("SideModalMenu: get town")
    public String getTown() {
        return $x("//span[contains(@class, 'city-toggle')]").text();
    }
}
