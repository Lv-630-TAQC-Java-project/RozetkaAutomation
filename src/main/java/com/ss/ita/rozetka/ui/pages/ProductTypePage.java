package com.ss.ita.rozetka.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementNotFound;
import com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ProductTypePage extends HeaderPage {

    public ProductPage openProductPage(int productNumber) {
        $$x("//li[contains(@class,'catalog-grid')]").get(productNumber).click();
        return new ProductPage();
    }

    public ProductTypePage chooseSubCategory(ProductCategoryAndSubCategory subCategory) {
        $x(format("//a[contains(@href,'%s')]", subCategory.getName())).click();
        return this;
    }
    public ProductTypePage openProductsListPage(int numberPage){
        $x(String.format("(//li[contains(@class, 'pagination__item')])[%s]", numberPage)).click();
        return new ProductTypePage();
    }

    public boolean isSuccessSearchText() {
        try {
            return !$x("//div[@class='catalog-empty']")
                    .shouldBe(Condition.visible)
                    .isDisplayed();
        } catch (ElementNotFound exception) {
            return true;
        }
    }
}
