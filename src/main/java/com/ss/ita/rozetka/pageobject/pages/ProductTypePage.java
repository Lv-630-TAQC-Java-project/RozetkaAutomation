package com.ss.ita.rozetka.pageobject.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.pageobject.utils.ProductsListSortType;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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

    @Step("ProductTypePage: get {productNumber} product title")
    public String getProductTitle(int productNumber) {
        return $x(String.format("(//span[contains(@class,'goods-tile__title')])[%s]", productNumber)).getText();
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

    @Step("ProductPage: get product type page visibility status by locating page heading")
    public Boolean isOpened() {
        return $x("//h1[@class = 'catalog-heading ng-star-inserted']")
                .shouldBe(Condition.exist)
                .is(Condition.visible);
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

    @Step("ProductTypePage: sort products list {sortType}")
    public ProductTypePage sortProductsListBy(ProductsListSortType sortType) {
        $x(String.format("//select[contains(@class,select-css)]/option[@value='%s']", sortType.getXPathValue())).click();
        return this;
    }

    @Step("ProductTypePage: open products list page number - {numberProductsListPage}")
    public ProductTypePage openProductsListPage(int numberProductsListPage) {
        $x(String.format("//li[contains(@class,'pagination__item')]/a[contains(@href, 'page=%s')]", numberProductsListPage)).click();
        return this;
    }

    @Step("ProductTypePage: get product prices list")
    public List<BigDecimal> getProductPricesList() {
        return $$x("//span[contains(@class, 'goods-tile__price-value')]")
                .shouldBe(CollectionCondition.sizeLessThanOrEqual(60))
                .texts()
                .stream()
                .map(price -> price.replaceAll(" ", StringUtils.EMPTY))
                .map(price -> new BigDecimal(price))
                .collect(Collectors.toList());
    }
}
