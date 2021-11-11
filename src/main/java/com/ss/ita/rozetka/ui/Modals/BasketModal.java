package com.ss.ita.rozetka.ui.Modals;

import com.codeborne.selenide.ElementsCollection;
import com.ss.ita.rozetka.ui.pages.OrderingPage;
import com.ss.ita.rozetka.ui.pages.ProductPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class BasketModal {

    public ProductPage continueBuying() {
        $x("//a[contains(@class,'button button_size_medium ')]").click();
        return new ProductPage();
    }

    public OrderingPage orderProducts() {
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
