package com.ss.ita.rozetka.ui.pages;

import com.ss.ita.rozetka.ui.Modals.BasketModal;
import com.ss.ita.rozetka.ui.elements.Header;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends HeaderPage {

    public BasketModal addProductToBasket() {
        $x("//button[contains(@class,'buy-button button button_')]").click();
        return new BasketModal();
    }

}
