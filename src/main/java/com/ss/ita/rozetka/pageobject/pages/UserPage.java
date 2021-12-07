package com.ss.ita.rozetka.pageobject.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UserPage {

    @Step("UserPage: Open wish list")
    public UserPage openWishList() {
        $x("(//*[name()='svg'][@aria-hidden='true'])[20]").click();
        return this;
    }

    @Step("UserPage: get product title {productNumber}")
    public String getProductTitle(int productNumber) {
            return $x(String.format("(//span[contains(@class,'goods-tile__title')])[%s]", productNumber)).getText();
    }

    @Step("UserPage: Select product {productNumber}")
    public UserPage selectProductInWishList(int productNumber) {
        $x(String.format(("(//*[@class='tile-checkbox ng-star-inserted'])[%s]"), productNumber)).click();
        return this;
    }

    @Step("UserPage: remove product from wish list")
    public UserPage removeProductFromWishList() {
        $("div.wish-details__actions>button:nth-child(3)").click();
        return this;
    }
}
