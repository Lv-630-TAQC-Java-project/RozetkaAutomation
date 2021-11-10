package com.ss.ita.rozetka.ui.pages;

import com.codeborne.selenide.SelenideElement;
import com.ss.ita.rozetka.ui.Modals.BasketModal;
import com.ss.ita.rozetka.ui.Modals.CatalogModal;
import com.ss.ita.rozetka.ui.Modals.HamburgerModal;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Header {

    public ProductTypePage doSearch(String searchText) {
        return setSearchTerms(searchText).search();
    }

    public Header setSearchTerms(String searchText) {
        SelenideElement input = $("input.search-form__input");
        input.clear();
        input.sendKeys(searchText);
        return this;
    }

    public ProductTypePage search() {
        $("button.button_color_green").click();
        return new ProductTypePage();
    }

    public Header changeLanguage(String language) {
        $x(String.format("//a[normalize-space()='%s']", language)).click();
        return this;
    }

    public HamburgerModal openHamburgerModal() {
        $x("//button[@class='header__button']").click();
        return new HamburgerModal();
    }

    public CatalogModal openCatalogModal() {
        $(By.id("fat-menu")).click();
        return new CatalogModal();
    }

    public BasketModal openBasketModal() {
        $x("//button[@class = 'header__button ng-star-inserted header__button--active']").click();
        return new BasketModal();
    }
}
