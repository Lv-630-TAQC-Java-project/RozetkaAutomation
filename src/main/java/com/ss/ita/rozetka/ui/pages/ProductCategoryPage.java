package com.ss.ita.rozetka.ui.pages;

import com.codeborne.selenide.Condition;
import com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class ProductCategoryPage extends HeaderPage {

    @Step("ProductCategoryPage: open product type page by category {categoryOrSubCategory}")
    public ProductTypePage openProductTypePage(ProductCategoryAndSubCategory categoryOrSubCategory) {
        $x(format("//a[contains(@href,'%s')]", categoryOrSubCategory.getName())).click();
        return new ProductTypePage();
    }

    @Step("ProductCategoryPage: get product category page heading visibility status")
    public Boolean isProductCategoryPageHeadingVisible() {
        return $x("//h1[@class = 'portal__heading ng-star-inserted']").is(Condition.visible);
    }
}

