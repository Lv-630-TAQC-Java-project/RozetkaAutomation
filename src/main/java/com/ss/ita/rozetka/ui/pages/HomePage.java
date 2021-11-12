package com.ss.ita.rozetka.ui.pages;

import com.codeborne.selenide.Selenide;
import com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static com.codeborne.selenide.Condition.visible;


public class HomePage extends HeaderPage {

    @Step("Open Rozetka home page")
    public HomePage open() {
        Selenide.open("https://rozetka.com.ua");
        capturePNG();
        return this;
    }
    @Step("Open category {category}")
    public ProductCategoryPage openProductCategoryPage(GeneralProductCategory category) {
        $x(format("//div[contains(@class,'menu-wrapper_state_static')]/descendant::a[contains(@href,'%s')]", category.getName())).click();
        return new ProductCategoryPage();
    }

    public String getRecentlyViewedProductName(int itemNumber) {
        return $x(format("//section[@class = 'main-goods ng-star-inserted'][1]//ul/li[%s]//a[@class = 'tile__title']", itemNumber)).getText();
    }
}
