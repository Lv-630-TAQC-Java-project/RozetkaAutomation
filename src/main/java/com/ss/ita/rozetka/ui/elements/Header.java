package com.ss.ita.rozetka.ui.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.ss.ita.rozetka.ui.Modals.*;
import com.ss.ita.rozetka.ui.pages.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class Header {

    @Step("Header: do search of term {searchText}")
    public ProductTypePage doSearch(String searchText) {
        return setSearchTerms(searchText).search();
    }

    @Step("Header: set search field by term {searchText}")
    public Header setSearchTerms(String searchText) {
        SelenideElement input = $("input.search-form__input");
        input.clear();
        input.sendKeys(searchText);
        return this;
    }

    @Step("Header: click on button search")
    public ProductTypePage search() {
        $("button.button_color_green").click();
        return new ProductTypePage();
    }

    @Step("Header: change language to {language}")
    public Header changeLanguage(String language) {
        $x("//a[normalize-space()='" + language + "']").click();
        return this;
    }

    @Step("Header: open side modal menu")
    public HamburgerModal openHamburgerModal() {
        $x("//button[@class='header__button']").click();
        return new HamburgerModal();
    }

    @Step("Header: open catalog modal")
    public boolean isCatalogModalDisplayed() {
        return $(".menu-wrapper").is(Condition.visible);
    }

    public CatalogModal openCatalogModal() {
        if (!isCatalogModalDisplayed()) {
            $(By.id("fat-menu")).click();
        }
        return new CatalogModal();
    }

    @Step("Header: open basket modal")
    public Header closeCatalogModal() {
        if (isCatalogModalDisplayed()) {
            $(By.id("fat-menu")).click();
        }
        return new Header();
    }

    public BasketModal openBasketModal() {
        $x("//button[@class = 'header__button ng-star-inserted header__button--active']").click();
        return new BasketModal();
    }

    @Step("Header: open home page")
    public HomePage openHomePage() {
        $x("//a[@class='header__logo']").click();
        return new HomePage();
    }
}
