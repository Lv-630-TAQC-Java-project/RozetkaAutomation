package com.ss.ita.rozetka.ui.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;

import static com.codeborne.selenide.Selenide.$x;

public class OrderingPage {

    @Step("OrderingPage: get total products price")
    public int getTotalProductsPrice() {
        String price = ($x("//dd[@class = 'checkout-total__value checkout-total__value_size_large']").text());
        return Integer.parseInt(price.replaceAll("[^0-9]", StringUtils.EMPTY));
    }

    @Step("OrderingPage: get sidebar status")
    public OrderingPage sidebarShouldBeVisible() {
        $x("//div[@class = 'checkout-sidebar ng-star-inserted']").shouldBe(Condition.visible);
        return this;
    }

    @Step("OrderingPage: get product title")
    public String getProductTitle() {
        return $x("//div[@class = 'checkout-product__title-product']").text();
    }
}
