package com.ss.ita.rozetka.pageobject.modals;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.ss.ita.rozetka.ui.pages.*;
import com.ss.ita.rozetka.pageobject.pages.*;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static java.lang.String.format;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BasketModal<T> {
    // This template should only be used in String.format()
    // with product name as a second argument
    private static final String PRODUCT_XPATH_TEMPLATE_FOR_TITLE = "//single-modal-window//li[contains(., '%s')]";
    private final T pageObject;

    public BasketModal(T pageObject) {
        this.pageObject = pageObject;
    }

    @Step("BasketModal: order products added to basket")
    public OrderingPage openOrderingPage() {
        $x("//a[contains(@class, 'cart-receipt__submit')]").click();
        return new OrderingPage();
    }

    @Step("BasketModal: get products total price")
    public int getProductsTotalPrice() {
        String sum = $x("//div[contains(@class,'sum-price')]//span[1]").text();
        return Integer.parseInt(sum);
    }

    @Step("BasketModal: get total products price")
    public int getTotalProductsPrice() {
        return Integer.parseInt(getTotalProductsPriceWithCurrency().replaceAll("\\D", ""));
    }

    @Step("BasketModal: waiting for price to change from {totalPriceBefore}")
    private void waitForTotalPriceToUpdate(int totalPriceBefore) {
        SelenideElement totalPriceSpan = $x("//div[@class='cart-receipt__sum-price']/span[1]");
        if (totalPriceSpan.is(exist)) {
            totalPriceSpan.shouldNotHave(text(String.valueOf(totalPriceBefore)));
        }
    }

    @Step("BasketModal: remove product with title {productTitle}")
    public BasketModal<T> removeProduct(String productTitle) {
        int totalPrice = getProductsTotalPrice();

        String productActionsXpath = String.format(
                PRODUCT_XPATH_TEMPLATE_FOR_TITLE + "//button[contains(@id, 'cartProductActions')]", productTitle);
        $x(productActionsXpath).click();
        $x("//rz-trash-icon/button").click();

        waitForTotalPriceToUpdate(totalPrice);
        return this;
    }

    @Step("BasketModal: close basket window")
    public T close() {
        $x("//button[contains(@class, 'modal__close')]").click();
        return pageObject;
    }

    @Step("BasketModal: increase amount on {numberOfProducts} product(s)")
    public BasketModal increaseAmountOfProduct(int numberOfProducts, int sequenceNumberOfProduct) {
        int specificNumber = sequenceNumberOfProduct + 1;
        SelenideElement increaseButton = $x(format("(//button[contains(@class,'cart-counter__button')])[%d]", specificNumber));
        for (int i = 0; i < numberOfProducts; i++) {
            increaseButton.click();
            waitForTotalPriceToUpdate(getTotalProductsPrice());
        }
        return this;
    }

    @Step("BasketModal: decrease amount on {number} product(s)")
    public BasketModal decreaseAmountOfProduct(int numberOfProducts, int sequenceNumberOfProduct) {
        SelenideElement decreaseButton = $x(format("(//button[contains(@class,'cart-counter__button')])[%d]", sequenceNumberOfProduct));
        for (int i = 0; i < numberOfProducts; i++) {
            decreaseButton.click();
            waitForTotalPriceToUpdate(getTotalProductsPrice());
        }
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
