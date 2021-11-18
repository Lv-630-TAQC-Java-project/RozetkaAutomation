package com.ss.ita.rozetka.pageobject.pages;

import com.ss.ita.rozetka.pageobject.modals.BasketModal;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;

import static com.codeborne.selenide.Selenide.*;

public class ProductPage extends HeaderPage {

    @Step("ProductPage: add product to basket")
    public BasketModal addProductToBasket() {
        $x("//button[contains(@class,'buy-button button button_')]").click();
        return new BasketModal();
    }

    @Step("ProductPage: add product to comparison")
    public ProductPage addToComparison() {
        $x("//button[contains(@class, 'compare-button')]").click();
        return this;
    }

    @Step("ProductPage: get product price")
    public int getPrice() {
        String value = $x("//p[contains(@class, 'product-prices__big')]").text();
        return Integer.parseInt(value.replaceAll("\\D", StringUtils.EMPTY));
    }

    @Step("ProductPage: get product name")
    public String getName() {
        return $x("//h1[@class = 'product__title']").text();
    }
}
