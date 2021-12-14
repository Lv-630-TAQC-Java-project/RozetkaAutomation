package com.ss.ita.rozetka.pageobject.elements;

import com.ss.ita.rozetka.pageobject.pages.own_cabinet.RecentlyViewedProductsPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class OwnCabinetSideMenu {

    @Step("RecentlyViewedProductsPage: open recently viewed products page")
    public RecentlyViewedProductsPage openRecentlyViewedProductsPage() {
        $("li.cabinet-navigation__item:nth-child(3)>a.cabinet-navigation__link").click();
        return new RecentlyViewedProductsPage();
    }
}
