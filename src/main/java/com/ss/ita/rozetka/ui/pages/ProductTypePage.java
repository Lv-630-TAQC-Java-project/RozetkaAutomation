package com.ss.ita.rozetka.ui.pages;

import com.codeborne.selenide.CollectionCondition;
import com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.ui.util.ProductsListSortType;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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

    @Step("ProductPage: verify that product type page heading is visible")
    public Boolean isProductTypePageHeadingVisible() {
        return $x("//h1[@class = 'catalog-heading ng-star-inserted']").isDisplayed();
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

    @Step("ProductTypePage: get products list prices")
    public List<BigDecimal> getProductsListPrices() {
        return $$x("//span[contains(@class, 'goods-tile__price-value')]")
                .shouldBe(CollectionCondition.sizeLessThanOrEqual(60))
                .texts()
                .stream()
                .map(price -> price.replaceAll(" ", StringUtils.EMPTY))
                .map(price -> new BigDecimal(price))
                .collect(Collectors.toList());
    }
}
