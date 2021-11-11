package com.ss.ita.rozetka.ui.Modals;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.ss.ita.rozetka.ui.pages.OrderingPage;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class BasketModal {
    private static final  String PRODUCT_XPATH_WITH_NAME = "//single-modal-window//li[contains(., '%s')]";

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
        String countFieldXpath = String.format(PRODUCT_XPATH_WITH_NAME, productName) +
                "%s//input[contains(@class, 'cart-counter__input')]";
        SelenideElement countField = $x(countFieldXpath);
        countField.clear();
        countField.sendKeys(String.valueOf(count));
        return this;
    }

    private void waitForTotalPriceToUpdate(int totalPriceBefore) {
        $(".cart-receipt__sum-price > span").shouldNotHave(Condition.text(String.valueOf(totalPriceBefore)));
    }

    public BasketModal removeProduct(String productName) {
        String productActionXpath = String.format(PRODUCT_XPATH_WITH_NAME, productName) + "//button[contains(@id, 'cartProductActions')]";
        $x(productActionXpath).click();
        $x("//rz-trash-icon/button").click();
        return this;
    }

    public void close() {
        $x("//button[contains(@class, 'modal__close')]").click();
    }
}
