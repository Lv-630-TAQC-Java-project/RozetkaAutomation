package com.ss.ita.rozetka.ui.pages;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends Header {

    public ProductPage addProductToComparison() {
        $x("//button[@class='compare-button ng-star-inserted']").click();
        return new ProductPage();
    }

}
