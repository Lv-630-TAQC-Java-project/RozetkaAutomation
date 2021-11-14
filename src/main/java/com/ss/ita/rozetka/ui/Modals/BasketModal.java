package com.ss.ita.rozetka.ui.Modals;

import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import com.ss.ita.rozetka.ui.pages.OrderingPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class BasketModal {
    // This pattern should only be used in String.format()
    // with product name as a second argument
    private static final String PRODUCT_XPATH_PATTERN_FOR_NAME = "//single-modal-window//li[contains(., '%s')]";

    public OrderingPage openOrderingPage() {
        $x("//a[contains(@class, 'cart-receipt__submit')]").click();
        return new OrderingPage();
    }

    public int getProductsTotalPrice() {
        String sum = $x("//div[contains(@class,'sum-price')]").getAttribute("textContent");
        return Integer.parseInt(sum.replaceAll("\\D", ""));
    }

    public boolean isEmpty() {
        return $(".cart-dummy").is(exist);
    }

    public List<String> getProductNames() {
        return $$("li.cart-list__item a.cart-product__title")
                .shouldHave(CollectionCondition.sizeGreaterThan(0))
                .texts();
    }

    public BasketModal setProductCount(String productName, int count) {
        int totalPrice = getProductsTotalPrice();

        String countFieldXpath = String.format(PRODUCT_XPATH_PATTERN_FOR_NAME, productName) +
                "//input[contains(@class, 'cart-counter__input')]";
        SelenideElement countField = $x(countFieldXpath);

        // Skips waiter if product count is changed to the same value
        // as it was before (from 1 changed to 1 etc.)
        if (String.valueOf(count).equals(countField.attr("value"))){
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

    public BasketModal removeProduct(String productName) {
        int totalPrice = getProductsTotalPrice();

        String productActionXpath = String.format(PRODUCT_XPATH_PATTERN_FOR_NAME, productName) + "//button[contains(@id, 'cartProductActions')]";
        $x(productActionXpath).click();
        $x("//rz-trash-icon/button").click();

        waitForTotalPriceToUpdate(totalPrice);
        return this;
    }

    public void close() {
        $x("//button[contains(@class, 'modal__close')]").click();
    }
}
