package com.ss.ita.rozetka.pageobject.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.ss.ita.rozetka.pageobject.elements.Product;
import com.ss.ita.rozetka.pageobject.elements.filters.FilterSideBar;
import com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.pageobject.utils.ProductsListSortType;
import io.qameta.allure.Step;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;
import static com.ss.ita.rozetka.pageobject.utils.PageUtil.isElementVisible;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class ProductTypePage extends HeaderPage {
    @Getter
    private final FilterSideBar filterSideBar = new FilterSideBar();

    @Step("ProductTypePage: open product page by product number {productNumber}")
    public ProductPage openProductPage(int productNumber) {
        $x(String.format(("//div[@class='goods-tile__inner'][%s]"), productNumber)).click(); //to open the same product as in getProduct method
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
    public boolean isOpened() {
        return isElementVisible("//h1[@class = 'catalog-heading ng-star-inserted']");
    }

    @Step("ProductTypePage: get display status select sorting type")
    public boolean isSelectSortingTypeDisplayed() {
        return isElementVisible("//select[contains(@class,'select-css')]");
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
    public List<Integer> getProductPricesList() {
        return $$x("//span[contains(@class, 'goods-tile__price-value')]")
                .shouldBe(CollectionCondition.sizeLessThanOrEqual(60))
                .texts()
                .stream()
                .map(price -> price.replaceAll(" ", EMPTY))
                .map(price -> Integer.valueOf(price))
                .collect(Collectors.toList());
    }

    @Step("ProductTypePage: filter products by {parameter}")
    public ProductTypePage filterProductsByParameters(String parameter) {
        $(String.format("label[for='%s']", parameter)).shouldBe(Condition.enabled).click();

        return new ProductTypePage();
    }

    @Step("ProductTypePage: add product count to comparison")
    public ProductTypePage addProductCountToComparison(int productCount) {
        for (int i = 0; i < productCount; i++) {
            $x(format("(//button[@class='compare-button ng-star-inserted'])[%s]", i + 1)).click();
        }
        return this;
    }

    @Step("ProductTypePage: get product by number {numberProduct}")
    public Product getProduct(int numberProduct) {
        return new Product(String.format(("(//div[@class='goods-tile__inner'])[%s]"), numberProduct));
    }

    @Step("ProductTypePage: get count of selected products by filter")
    public int getSelectedProductsAmount() {
        return Integer.parseInt($x("//rz-selected-filters/div/p").getText().replaceAll("\\D", EMPTY));
    }
}
