package com.ss.ita.rozetka.ui.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class HomePage extends Header {

    private static final String GENERAL_PRODUCT_CATEGORY_TEMPLATE = "//div[contains(@class,'menu-wrapper_state_static')]/descendant::a[contains(@href,'%s')]";

    public HomePage open() {
        Selenide.open("https://rozetka.com.ua");

        return this;
    }

    public ProductCategoryPage openProductCategoryPage(String generalProductCategory) {
        $x(format("//div[contains(@class,'menu-wrapper_state_static')]/descendant::a[contains(@href,'%s')]", generalProductCategory)).click();
        return new ProductCategoryPage();
    }
}
