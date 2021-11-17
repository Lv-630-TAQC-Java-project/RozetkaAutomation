package com.ss.ita.rozetka.ui.pages;

import com.codeborne.selenide.Selenide;
import com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class HomePage extends HeaderPage {

    @Step("HomePage: open Rozetka home page")
    public HomePage open() {
        Selenide.open("https://rozetka.com.ua");
        return this;
    }

    @Step("HomePage: open category {category}")
    public ProductCategoryPage openProductCategoryPage(GeneralProductCategory category) {
        $x(format("//div[contains(@class,'menu-wrapper_state_static')]/descendant::a[contains(@href,'%s')]", category.getName())).click();
        return new ProductCategoryPage();
    }

    @Step("HomePage: verify that Main Menu Categories is displayed")
    public boolean isMainMenuCategoriesDisplayed(){
        return $x("//ul[@class='menu-categories menu-categories_type_main']").isDisplayed();
    }
}
