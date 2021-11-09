package com.ss.ita.rozetka.ui.Modals;

import com.codeborne.selenide.ElementsCollection;
import com.ss.ita.rozetka.ui.pages.OrderingPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class BasketModal {

    public OrderingPage openOrderingPage() {
        $x("//a[contains(@class, 'cart-receipt__submit')]").click();
        return new OrderingPage();
    }

    public String getPriceWithCurrency() {
        return $x("//div[contains(@class,'sum-price')]").getAttribute("textContent");
    }

    public int getPrice() {
        return Integer.parseInt(getPriceWithCurrency().replaceAll("\\D", ""));
    }

    public boolean isBasketEmpty() {
        return getProductsList().isEmpty();
    }

    private ElementsCollection getProductsList() {
        return $$x("//li[contains(@class, 'cart-list__item')]");
    }
}
