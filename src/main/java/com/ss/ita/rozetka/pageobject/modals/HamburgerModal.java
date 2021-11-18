package com.ss.ita.rozetka.pageobject.modals;

import com.ss.ita.rozetka.pageobject.elements.Header;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

// class should be renamed by another PR to SideMenuModal
public class HamburgerModal {

    @Step("SideModalMenu: close side modal menu")
    public Header closeHamburgerModal() {
        $x("//button[@class='side-menu__close']").click();
        return new Header();
    }

    @Step("SideModalMenu: open change city modal")
    public ChangeCityModal startChangingCity() {
        $x("//button[contains(@class, 'city-toggle')]").click();
        return new ChangeCityModal();
    }

    @Step("SideModalMenu: get city")
    public String getCity() {
        return $x("//span[contains(@class, 'city-toggle')]").text();
    }
}
