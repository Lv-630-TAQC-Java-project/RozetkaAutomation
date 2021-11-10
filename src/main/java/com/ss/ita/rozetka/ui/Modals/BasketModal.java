package com.ss.ita.rozetka.ui.Modals;

import com.codeborne.selenide.ElementsCollection;
import com.ss.ita.rozetka.ui.pages.*;

import static com.codeborne.selenide.Selenide.*;

public class BasketModal {

    public OrderingPage openOrderingPage() {
        $x("//a[contains(@class, 'cart-receipt__submit')]").click();
        return new OrderingPage();
    }

    public String getTotalProductsPriceWithCurrency() {
        return $x("//div[contains(@class,'sum-price')]").getAttribute("textContent");
    }

    public int getTotalProductsPrice() {
        return Integer.parseInt(getTotalProductsPriceWithCurrency().replaceAll("\\D", ""));
    }

    public boolean isBasketEmpty() {
        return getProductsList().isEmpty();
    }

    private ElementsCollection getProductsList() {
        return $$x("//li[contains(@class, 'cart-list__item')]");
    }
}
