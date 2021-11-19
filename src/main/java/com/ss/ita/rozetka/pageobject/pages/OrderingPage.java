package com.ss.ita.rozetka.pageobject.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Integer.parseInt;

public class OrderingPage {

    @Step("OrderingPage: get total products price")
    public int getTotalProductsPrice() {
        return parseInt($x("//dd[@class = 'checkout-total__value checkout-total__value_size_large']")
                .text()
                .replaceAll("[^0-9]", StringUtils.EMPTY));
    }

    @Step("OrderingPage: get ordering page status, assert in test")
    public boolean isOrderingPageOpened() {
        return $x("//div[@class = 'checkout-sidebar ng-star-inserted']")
                .shouldBe(Condition.visible)
                .isDisplayed();
    }

    @Step("OrderingPage: get product title")
    public String getProductTitle() {
        return $x("//div[@class = 'checkout-product__title-product']").text();
    }
}
