package com.ss.ita.rozetka.ui.Modals;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.ss.ita.rozetka.ui.pages.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BasketModal {

    @Step("BasketModal: continue buying products")
    public ProductPage continueBuying() {
        $x("//a[contains(@class,'button button_size_medium ')]").click();
        return new ProductPage();
    }

    @Step("BasketModal: order products you choose")
    public OrderingPage orderProducts() {
        $x("//a[contains(@class, 'cart-receipt__submit')]").click();
        return new OrderingPage();
    }

    @Step("BasketModal: get total products price with currency")
    public String getTotalProductsPriceWithCurrency() {
        return $x("//div[contains(@class,'sum-price')]").getAttribute("textContent");
    }

    @Step("BasketModal: get total products price")
    public int getTotalProductsPrice() {
        return Integer.parseInt(getTotalProductsPriceWithCurrency().replaceAll("\\D", ""));
    }

    @Step("BasketModal: get basket status")
    public boolean isBasketEmpty() {
        return getProductsList().isEmpty();
    }

    @Step("BasketModal: get all products")
    private ElementsCollection getProductsList() {
        return $$x("//li[contains(@class, 'cart-list__item')]");
    }

    @Step("BasketModal: Add one item")
    public BasketModal increaseAmountOfProductPerUnit() {
        $x("(//button[contains(@class,'cart-counter__button')])[2]").click();
        waitForTotalPriceToUpdate(getTotalProductsPrice());
        return this;
    }
    @Step("BasketModal: Remove one item")
    public BasketModal decreaseAmountOfProductPerUnit() {
        $x("(//button[contains(@class,'cart-counter__button')])[1]").click();
        waitForTotalPriceToUpdate(getTotalProductsPrice());
        return this;
    }

    @Step("BasketModal: waiting for price to change from {totalPriceBefore}")
    private void waitForTotalPriceToUpdate(int totalPriceBefore) {
        SelenideElement totalPriceSpan = $x("//div[@class='cart-receipt__sum-price']/span[1]");
        if (totalPriceSpan.is(exist)) {
            totalPriceSpan.shouldNotHave(text(String.valueOf(totalPriceBefore)));
        }
    }
}
