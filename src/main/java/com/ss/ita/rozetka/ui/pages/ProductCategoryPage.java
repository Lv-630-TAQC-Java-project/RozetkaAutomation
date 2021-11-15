package com.ss.ita.rozetka.ui.pages;

import com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory;
import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.C;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ProductCategoryPage extends HeaderPage {

    @Step("ProductCategoryPage: open product type page by category {categoryOrSubCategory}")
    public ProductTypePage openProductTypePage(ProductCategoryAndSubCategory categoryOrSubCategory) {
        $x(format("//a[contains(@href,'%s')]", categoryOrSubCategory.getName())).click();
        return new ProductTypePage();
    }
}

