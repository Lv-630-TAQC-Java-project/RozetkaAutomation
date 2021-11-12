package com.ss.ita.rozetka.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class ProductTypePage extends HeaderPage {

    public ProductPage openProductPage(int productNumber) {
        $$x("//li[contains(@class,'catalog-grid')]").get(productNumber).click();
        return new ProductPage();
    }

    public ProductTypePage chooseSubCategory(ProductCategoryAndSubCategory subCategory) {
        $x(format("//a[contains(@href,'%s')]", subCategory.getName())).click();
        return this;
    }

    public boolean isThereMoreThanNProductsOnPagePresented(int n) {
        return $$(".catalog-grid__cell").size() > n;
    }
}
