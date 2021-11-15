package com.ss.ita.rozetka.ui.Modals;

import com.codeborne.selenide.Condition;
import com.ss.ita.rozetka.ui.elements.Header;

import static com.codeborne.selenide.Selenide.$x;

public class SideMenuModal {

    public Header closeSideMenuModal() {
        $x("//button[@class='side-menu__close']").click();
        $x("//nav[@class='drawer ng-star-inserted']").shouldNotBe(Condition.visible);
        return new Header();
    }
}
