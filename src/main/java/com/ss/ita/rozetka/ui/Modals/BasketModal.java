package com.ss.ita.rozetka.ui.Modals;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.ss.ita.rozetka.ui.pages.OrderingPage;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class BasketModal {
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

    private SelenideElement getProductByName(String productName) {
        String productXpath = String.format(
                "//single-modal-window//li[contains(., '%s')]",
                productName);
        return $x(productXpath);
    }

    public List<String> getProductNames() {
        return getProductList().stream()
                .map(product -> product.$x(".//a[@class='cart-product__title']").text())
                .collect(Collectors.toList());
    }

    public BasketModal setProductCountByName(String productName, int count) {
        SelenideElement countField = getProductByName(productName).$x(".//input[contains(@class, 'cart-counter__input')]");
        countField.clear();
        countField.sendKeys(count + "");
        waitForCirclingDonutToDisappear();
        return this;
    }

    private void waitForCirclingDonutToDisappear() {
        String loadingDonutXpath = "//div[contains(@class,'preloader_with_donut')]";
        $x(loadingDonutXpath).should(Condition.exist);
        $x(loadingDonutXpath).shouldNot(Condition.exist);
    }

    public BasketModal removeProductByName(String productName) {
        SelenideElement product = getProductByName(productName);
        product.$x(".//button[contains(@id, 'cartProductActions')]").click();
        product.$x(".//rz-trash-icon/button").click();
        return this;
    }

    public void close() {
        $x("//button[contains(@class, 'modal__close')]").click();
    }
}
