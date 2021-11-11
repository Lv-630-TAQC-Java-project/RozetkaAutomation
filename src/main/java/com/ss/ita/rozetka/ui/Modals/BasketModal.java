package com.ss.ita.rozetka.ui.Modals;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.ss.ita.rozetka.ui.pages.OrderingPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class BasketModal {
    // This pattern should only be used in String.format()
    // with product name as second argument
    private static final String PRODUCT_XPATH_PATTERN_FOR_NAME = "//single-modal-window//li[contains(., '%s')]";

    public OrderingPage order() {
        $x("//a[contains(@class, 'cart-receipt__submit')]").click();
        return new OrderingPage();
    }

    public int getProductsTotalPrice() {
        String sum = $x("//div[contains(@class,'sum-price')]").getAttribute("textContent");
        return Integer.parseInt(sum.replaceAll("\\D", ""));
    }

    public boolean isEmpty() {
        $("single-modal-window").should(Condition.exist);
        return getProductList().isEmpty();
    }

    private ElementsCollection getProductList() {
        return $$x("//li[contains(@class, 'cart-list__item')]");
    }

    public List<String> getProductNames() {
        return getProductList().texts();
    }

    public BasketModal setProductCount(String productName, int count) {
        int totalPrice = getProductsTotalPrice();

        String countFieldXpath = String.format(PRODUCT_XPATH_PATTERN_FOR_NAME, productName) +
                "//input[contains(@class, 'cart-counter__input')]";
        SelenideElement countField = $x(countFieldXpath);

        countField.clear();
        countField.sendKeys(String.valueOf(count));

        waitForTotalPriceToUpdate(totalPrice);
        return this;
    }

    private void waitForTotalPriceToUpdate(int totalPriceBefore) {
        SelenideElement totalPriceSpan = $x("//div[@class='cart-receipt__sum-price']/span[1]");
        if (isEmpty()) {
            totalPriceSpan.shouldNotHave(Condition.text(String.valueOf(totalPriceBefore)));
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
