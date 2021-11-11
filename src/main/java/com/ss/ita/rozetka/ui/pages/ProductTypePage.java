package com.ss.ita.rozetka.ui.pages;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class ProductTypePage extends Header {

    public ProductPage openProductPage(int productNumber) {
        $$x("//li[contains(@class,'catalog-grid')]").get(productNumber).click();
        return new ProductPage();
    }

    public ProductTypePage chooseSubCategory(String subCategory) {
        $x(format("//a[contains(@href,'%s')]", subCategory)).click();
        return this;
    }
}
