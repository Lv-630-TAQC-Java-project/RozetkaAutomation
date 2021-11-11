package com.ss.ita.rozetka.pageobject.pages;

import com.codeborne.selenide.Selenide;
import com.ss.ita.rozetka.pageobject.product.GeneralProductCategory;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
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

    public String getGreetingsText() {
        return $("h3.main-auth__heading").getText();
    }

    @Step("HomePage: get product number {itemNumber} from Recently Viewed Products list")
    public String getRecentlyViewedProductName(int itemNumber) {
        return $x(format("//section[@class = 'main-goods ng-star-inserted'][1]//ul/li[%s]//a[@class = 'tile__title']", itemNumber)).getText();
    }
}
