package com.ss.ita.rozetka.ui.pages.components;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class GoodsCart {
    // This method should open order page and return it.
    // It is not currently because of order page absence.
    @Deprecated
    public Object order() {
        return null;
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
