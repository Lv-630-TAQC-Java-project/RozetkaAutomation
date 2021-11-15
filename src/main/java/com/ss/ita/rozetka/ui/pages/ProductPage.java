package com.ss.ita.rozetka.ui.pages;

import com.ss.ita.rozetka.ui.Modals.BasketModal;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class ProductPage extends HeaderPage {

    @Step("ProductPage: add product to basket")
    public BasketModal addProductToBasket() {
        $x("//button[contains(@class,'buy-button button button_')]").click();
        return new BasketModal();
    }

    @Step("ProductPage: get product title")
    public String getProductTitle() {
        return $x("//h1[@class = 'product__title']").getText();
    }
}
