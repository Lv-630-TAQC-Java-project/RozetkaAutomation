package com.ss.ita.rozetka.pageobject.pages;

import com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class ProductCategoryPage extends HeaderPage {

    @Step("ProductCategoryPage: open product type page by category {categoryOrSubCategory}")
    public ProductTypePage openProductTypePage(ProductCategoryAndSubCategory categoryOrSubCategory) {
        $x(format("//div[@class='tile-cats']/child::a[contains(@href,'%s')]", categoryOrSubCategory.getName())).click();
        return new ProductTypePage();
    }
}

