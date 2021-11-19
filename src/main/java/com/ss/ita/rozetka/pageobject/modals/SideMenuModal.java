package com.ss.ita.rozetka.pageobject.modals;

import com.codeborne.selenide.Condition;
import com.ss.ita.rozetka.pageobject.elements.Header;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class SideMenuModal {

    @Step("SideMenuModal: close side menu  modal")
    public Header closeSideMenuModal() {
        $x("//button[@class='side-menu__close']").click();
        $x("//nav[@class='drawer ng-star-inserted']").shouldNotBe(Condition.visible);
        return new Header();
    }
}
