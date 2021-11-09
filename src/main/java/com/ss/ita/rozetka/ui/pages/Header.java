package com.ss.ita.rozetka.ui.pages;

import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Header {
    public SearchResultPage doSearch(String searchText) {
        return setSearchTerms(searchText).search();
    }

    public Header setSearchTerms(String searchText) {
        WebElement input = $("input.search-form__input");
        input.clear();
        input.sendKeys(searchText);
        return this;
    }

    public SearchResultPage search() {
        $("button.button_color_green").click();
        return new SearchResultPage();
    }

    public Header openCatalog() {
        $("svg.ng-tns-c5-0").click();
        return this;
    }

    public Header changeLanguage(String language) {
        $x("//a[normalize-space()='" + language + "']").click();
        return this;
    }
}
