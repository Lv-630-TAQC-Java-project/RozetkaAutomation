package com.ss.ita.rozetka.pageobject.pages.own_cabinet;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class RecentlyViewedProductsPage {
    @Step("RecentlyViewedProductsPage: clear recently viewed products list")
    public RecentlyViewedProductsPage clearRecentlyViewedProductsList() {
        $("button.button_color_white").click();
        return new RecentlyViewedProductsPage();
    }

    @Step("RecentlyViewedProductsPage: get product title {productNumber}")
    public String getProductTitle(int productNumber) {
        return $x(String.format("(//span[contains(@class,'goods-tile__title')])[%s]", productNumber)).getText();
    }

    @Step("RecentlyViewedProductsPage: is product list empty")
    public boolean isProductListEmpty() {
        return $$("div.goods-tile__inner")
                .shouldBe(CollectionCondition.size(0))
                .isEmpty();
    }
}
