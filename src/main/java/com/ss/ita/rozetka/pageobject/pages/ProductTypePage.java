package com.ss.ita.rozetka.pageobject.pages;

import com.codeborne.selenide.Condition;
import com.ss.ita.rozetka.pageobject.pages.HeaderPage;
import com.ss.ita.rozetka.pageobject.pages.ProductPage;
import com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory;
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

    @Step("ProductTypePage: get display status select sorting type")
    public boolean isSelectSortingTypeDisplayed() {
        try {
            return $x("//select[contains(@class,'select-css')]")
                    .shouldBe(Condition.visible)
                    .isDisplayed();
        } catch (AssertionError exception) {
            return false;
        }
    }
}
