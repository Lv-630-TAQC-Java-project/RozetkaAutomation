package com.ss.ita.rozetka.pageobject.pages;

import com.codeborne.selenide.Condition;
import com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ProductCategoryPage extends HeaderPage {

    @Step("ProductCategoryPage: open product type page by category {categoryOrSubCategory}")
    public ProductTypePage openProductTypePage(ProductCategoryAndSubCategory categoryOrSubCategory) {
        $x(format("//div[contains(@class,'tile-cats')]//a[contains(@href,'%s')]", categoryOrSubCategory.getName())).click();
        return new ProductTypePage();
    }

    @Step("ProductCategoryPage: get product category page visibility status by locating page heading")
    public Boolean isOpened() {
        try {
            return $x("//h1[@class = 'portal__heading ng-star-inserted']")
                    .should(Condition.exist)
                    .is(Condition.visible);
        } catch (AssertionError exception) {
            return false;
        }
    }
}

