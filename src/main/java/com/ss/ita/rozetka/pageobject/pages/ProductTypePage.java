package com.ss.ita.rozetka.pageobject.pages;

import com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory;
import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class ProductTypePage extends HeaderPage {

    @Step("ProductTypePage: open product page by product number {productNumber}")
    public ProductPage openProductPage(int productNumber) {
        $$x("//li[contains(@class,'catalog-grid')]").get(productNumber).click();
        return new ProductPage();
    }

    @Step("ProductTypePage: choose subcategory of product {subCategory}")
    public ProductTypePage chooseSubCategory(ProductCategoryAndSubCategory subCategory) {
        $x(format("//a[contains(@href,'%s')]", subCategory.getName())).click();
        return this;
    }

    @Step("ProductPage: verify that product type page heading is visible")
    public Boolean isProductTypePageHeadingVisible() {
        return $x("//h1[@class = 'catalog-heading ng-star-inserted']").isDisplayed();
    }

    @Step("ProductTypePage: get products count presented on page")
    public int getProductsCount() {
        return $$(".catalog-grid__cell")
                .shouldHave(CollectionCondition.sizeGreaterThan(1))
                .size();
    }
}
