package com.ss.ita.rozetka.ui.pages;

import com.codeborne.selenide.Condition;
import com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory;
import io.qameta.allure.Step;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class ProductCategoryPage extends HeaderPage {

    @Step("ProductCategoryPage: open product type page by category {categoryOrSubCategory}")
    public ProductTypePage openProductTypePage(ProductCategoryAndSubCategory categoryOrSubCategory) {
        $x(format("//a[contains(@href,'%s')]", categoryOrSubCategory.getName()))
                .shouldBe(Condition.visible, Duration.ofMillis(6000))
                .click();
        return new ProductTypePage();
    }
}

