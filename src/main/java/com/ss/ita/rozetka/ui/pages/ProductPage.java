package com.ss.ita.rozetka.ui.pages;

import com.ss.ita.rozetka.ui.Modals.BasketModal;
import io.qameta.allure.Step;
import com.ss.ita.rozetka.ui.elements.Header;

import static com.codeborne.selenide.Selenide.*;

public class ProductPage extends HeaderPage {

    public Header addProductToComparison() {
        $x("//button[@class='compare-button ng-star-inserted']").click();
        return new Header();
    }

    @Step("ProductPage: add product to basket")
    public BasketModal addProductToBasket() {
        $x("//button[contains(@class,'buy-button button button_')]").click();
        return new BasketModal();
    }

    public ProductPage addToComparison() {
        $x("//button[contains(@class, 'compare-button')]").click();
        return this;
    }

    public int getPrice() {
        String value = $x("//p[contains(@class, 'product-prices__big')]").text();
        return Integer.parseInt(value.replaceAll("\\D", ""));
    }

    public String getName() {
        return $("h1").text();
    }
}
