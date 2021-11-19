package com.ss.ita.rozetka.pageobject.pages;

import com.codeborne.selenide.Condition;
import com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
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

    @Step("ProductTypePage: get {productNumber} product title")
    public String getProductTitle(int productNumber) {
        return $x(String.format("(//span[contains(@class,'goods-tile__title')])[%s]", productNumber)).getText();
    }

    @Step("ProductPage: verify that product type page heading is visible")
    public Boolean isProductTypePageHeadingVisible() {
        return $x("//h1[@class = 'catalog-heading ng-star-inserted']").isDisplayed();
    }
  
    @Step("ProductPage: get product type page visibility status by locating page heading")
    public Boolean isOpened() {
        return $x("//h1[@class = 'catalog-heading ng-star-inserted']").is(Condition.visible);
    }
}
