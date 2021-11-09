package com.ss.ita.rozetka.ui.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.ss.ita.rozetka.ui.pages.OrderingPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class GoodsCart {
    public OrderingPage order() {
        $x("//a[contains(@class, 'cart-receipt__submit')]").click();
        return new OrderingPage();
    }

    public String getSumWithCurrency() {
        return $x("//div[contains(@class,'sum-price')]").getAttribute("textContent");
    }

    public int getSum() {
        return Integer.parseInt(getSumWithCurrency().replaceAll("\\D", ""));
    }

    public boolean isEmpty() {
        return getGoodsList().isEmpty();
    }

    private ElementsCollection getGoodsList() {
        return $$x("//li[contains(@class, 'cart-list__item')]");
    }
}
