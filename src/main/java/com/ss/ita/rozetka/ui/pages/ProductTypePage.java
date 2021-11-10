package com.ss.ita.rozetka.ui.pages;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ProductTypePage extends Header {

    private static final String PRODUCT_CATEGORY_OR_SUBCATEGORY_TEMPLATE = "//a[contains(@href,'%s')]";

    public ProductPage openProductPage(int productNumber) {
        $$x("//li[contains(@class,'catalog-grid')]").get(productNumber).click();
        return new ProductPage();
    }

    public ProductTypePage chooseSubCategory(String subCategory) {
        $x(format(PRODUCT_CATEGORY_OR_SUBCATEGORY_TEMPLATE, subCategory)).click();
        return this;
    }
}
