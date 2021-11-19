package com.ss.ita.rozetka.pageobject.modals;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import com.ss.ita.rozetka.pageobject.pages.*;
import io.qameta.allure.Step;


import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static java.lang.String.format;

import static com.codeborne.selenide.Selenide.*;

public class BasketModal<T> {
    // This template should only be used in String.format()
    // with product name as a second argument
    private static final String PRODUCT_XPATH_TEMPLATE_FOR_TITLE = "//single-modal-window//li[contains(., '%s')]";
    private final T pageObject;

    public BasketModal(T pageObject) {
        this.pageObject = pageObject;
    }


    @Step("BasketModal: get the basket emptiness status")
    public boolean isEmpty() {
        return $(".cart-dummy").is(exist);
    }

    @Step("BasketModal: get product titles")
    public List<String> getProductTitles() {
        return $$("li.cart-list__item a.cart-product__title")
                .shouldHave(CollectionCondition.sizeGreaterThan(0))
                .texts();
    }

    @Step("BasketModal: set count for product with title {productTitle} to {count}")
    public BasketModal<T> setProductCount(String productTitle, int count) {
        int totalPrice = getProductsTotalPrice();

        String countFieldXpath = String.format(
                PRODUCT_XPATH_TEMPLATE_FOR_TITLE + "//input[contains(@class, 'cart-counter__input')]", productTitle);
        SelenideElement countField = $x(countFieldXpath);

        if (String.valueOf(count).equals(countField.attr("value"))) {
            return this;
        }

        countField.clear();
        countField.sendKeys(String.valueOf(count));

        waitForTotalPriceToUpdate(totalPrice);
        return this;
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
            waitForTotalPriceToUpdate(getProductsTotalPrice());
        }
        return this;
    }

    @Step("BasketModal: decrease amount on {number} product(s)")
    public BasketModal decreaseAmountOfProduct(int numberOfProducts, int sequenceNumberOfProduct) {
        SelenideElement decreaseButton = $x(format("(//button[contains(@class,'cart-counter__button')])[%d]", sequenceNumberOfProduct));
        for (int i = 0; i < numberOfProducts; i++) {
            decreaseButton.click();
            waitForTotalPriceToUpdate(getProductsTotalPrice());
        }
        return this;
    }
}
