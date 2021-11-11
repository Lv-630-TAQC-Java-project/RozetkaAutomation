package com.ss.ita.rozetka.ui.pages;

import com.codeborne.selenide.Selenide;
import com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class HomePage extends HeaderPage {

    public HomePage open() {
        Selenide.open("https://rozetka.com.ua");
        return this;
    }

    public ProductCategoryPage openProductCategoryPage(GeneralProductCategory category) {
        $x(format("//div[contains(@class,'menu-wrapper_state_static')]/descendant::a[contains(@href,'%s')]", category.getName())).click();
        return new ProductCategoryPage();
    }
}
