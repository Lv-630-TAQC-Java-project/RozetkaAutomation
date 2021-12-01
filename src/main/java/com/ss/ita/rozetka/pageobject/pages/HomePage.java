package com.ss.ita.rozetka.pageobject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.ss.ita.rozetka.pageobject.product.GeneralProductCategory;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

import java.util.List;

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

    @Step("HomePage: get greetings text")
    public String getGreetingsText() {
        return $("h3.main-auth__heading").getText();
    }

    @Step("HomePage: get home page visibility status by locating slider")
    public boolean isOpened() {
        return $x("//div[@class = 'simple-slider__holder']").is(Condition.visible);
    }

    @Step("HomePage: get product name number {itemNumber} from Recently Viewed Products list")
    public String getRecentlyViewedProductName(int itemNumber) {
        return $x(format("//section[@class = 'main-goods ng-star-inserted'][1]//ul/li[%s]//a[@class = 'tile__title']", itemNumber)).getText();
    }

    @Step("HomePage: get recently viewed products names list from first to {intNumber} Recently Viewed Products list")
    public List<String> getRecentlyViewedProductsNames(/*int itemNumber*/){
        $x("//section[@class = 'main-goods ng-star-inserted'][1]//ul/li//a[@class = 'tile__title']").shouldBe(Condition.visible);
        return  $$x("//section[@class = 'main-goods ng-star-inserted'][1]//ul/li//a[@class = 'tile__title']").texts();
    }

    @Step("HomePage: get display status main menu categories")
    public boolean isMainMenuCategoriesDisplayed() {
        return $x("//ul[@class='menu-categories menu-categories_type_main']").isDisplayed();
    }
}
