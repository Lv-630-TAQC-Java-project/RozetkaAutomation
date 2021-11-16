package com.ss.ita.rozetka.ui.Modals;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import com.ss.ita.rozetka.ui.pages.OrderingPage;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BasketModal <T>{
    private final T rootPage;

    public BasketModal(T rootPage) {
        this.rootPage = rootPage;
    }
    // This pattern should only be used in String.format()
    // with product name as a second argument
    private static final String PRODUCT_XPATH_PATTERN_FOR_NAME = "//single-modal-window//li[contains(., '%s')]";

    @Step("BasketModal: order products you chose")
    public OrderingPage openOrderingPage() {
        $x("//a[contains(@class, 'cart-receipt__submit')]").click();
        return new OrderingPage();
    }

    @Step("BasketModal: get total products price")
    public int getProductsTotalPrice() {
        String sum = $x("//div[contains(@class,'sum-price')]//span[1]")
                .getAttribute("textContent");
        return Integer.parseInt(sum);
    }

    @Step("BasketModal: check if basket is empty")
    public boolean isEmpty() {
        return $(".cart-dummy").is(exist);
    }

    @Step("BasketModal: get product names ")
    public List<String> getProductNames() {
        return $$("li.cart-list__item a.cart-product__title")
                .shouldHave(CollectionCondition.sizeGreaterThan(0))
                .texts();
    }

    @Step("BasketModal: set count for product with name {productName} to {count}")
    public BasketModal<T> setProductCount(String productName, int count) {
        int totalPrice = getProductsTotalPrice();

        String countFieldXpath = String.format(
                PRODUCT_XPATH_PATTERN_FOR_NAME + "//input[contains(@class, 'cart-counter__input')]", productName);
        SelenideElement countField = $x(countFieldXpath);

        if (String.valueOf(count).equals(countField.attr("value"))) {
            return this;
        }

        countField.clear();
        countField.sendKeys(String.valueOf(count));

        waitForTotalPriceToUpdate(totalPrice);
        return this;
    }

    private void waitForTotalPriceToUpdate(int totalPriceBefore) {
        SelenideElement totalPriceSpan = $x("//div[@class='cart-receipt__sum-price']/span[1]");
        if (totalPriceSpan.is(exist)) {
            totalPriceSpan.shouldNotHave(text(String.valueOf(totalPriceBefore)));
        }
    }

    @Step("BasketModal: remove product with name {productName}")
    public BasketModal<T> removeProduct(String productName) {
        int totalPrice = getProductsTotalPrice();

        String productActionXpath = String.format(
                PRODUCT_XPATH_PATTERN_FOR_NAME + "//button[contains(@id, 'cartProductActions')]", productName);
        $x(productActionXpath).click();
        $x("//rz-trash-icon/button").click();

        waitForTotalPriceToUpdate(totalPrice);
        return this;
    }


    @Step("BasketModal: close basket window")
    public T close() {
        $x("//button[contains(@class, 'modal__close')]").click();
        return rootPage;
    }
}
