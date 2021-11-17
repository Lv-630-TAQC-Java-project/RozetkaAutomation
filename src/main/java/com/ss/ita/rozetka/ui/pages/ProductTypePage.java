package com.ss.ita.rozetka.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementNotFound;
import com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class ProductTypePage extends HeaderPage {

    @Step("ProductPage: open product page by product number {productNumber}")
    public ProductPage openProductPage(int productNumber) {
        $$x("//li[contains(@class,'catalog-grid')]").get(productNumber).click();
        return new ProductPage();
    }

    @Step("ProductPage: choose subcategory of product {subCategory}")
    public ProductTypePage chooseSubCategory(ProductCategoryAndSubCategory subCategory) {
        $x(format("//a[contains(@href,'%s')]", subCategory.getName())).click();
        return this;
    }

    @Step("ProductTypePage: verify that Select Sorting Type is displayed")
    public boolean isSelectSortingTypeDisplayed() {
        try {
            return $x("//select[contains(@class,'select-css')]")
                    .shouldBe(Condition.visible)
                    .isDisplayed();
        } catch (ElementNotFound exception) {
            return false;
        }
    }
}
