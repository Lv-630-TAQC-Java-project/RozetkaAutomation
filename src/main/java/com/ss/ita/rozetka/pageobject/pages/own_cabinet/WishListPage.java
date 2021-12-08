package com.ss.ita.rozetka.pageobject.pages.own_cabinet;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class WishListPage {

    @Step("WishListPage: get product title {productNumber}")
    public String getProductTitle(int productNumber) {
            return $x(String.format("(//span[contains(@class,'goods-tile__title')])[%s]", productNumber)).getText();
    }

    @Step("WishListPage: Select product {productNumber}")
    public WishListPage selectProductInWishList(int productNumber) {
        $x(String.format(("(//*[@class='tile-checkbox ng-star-inserted'])[%s]"), productNumber)).click();
        return this;
    }

    @Step("WishListPage: remove product from wish list")
    public WishListPage removeProductFromWishList() {
        $("div.wish-details__actions>button:nth-child(3)").click();
        return this;
    }

    @Step("WishListPage: get products list size")
    public int getProductsListSize() {
        return $$x("(//a[@class='goods-tile__picture ng-star-inserted'])").size();
    }
}
