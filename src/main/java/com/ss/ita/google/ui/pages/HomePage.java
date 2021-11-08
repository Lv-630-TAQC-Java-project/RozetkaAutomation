package com.ss.ita.google.ui.pages;

import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    public SearchResultPage doSearch(String searchText) {
        return setSearchTerms(searchText).search();
    }

    public HomePage setSearchTerms(String terms) {
        WebElement input = $x("//input[@class='gLFyf gsfi']");
        input.clear();
        input.sendKeys(terms);
        return this;
    }

    public SearchResultPage search() {
        $x("//input[@class='gNO89b'][1]").click();
        return new SearchResultPage();
    }

    public HomePage changeLanguage(String language) {
        $x("//a[contains(text(),'" + language + "')]").click();
        return this;
    }

    public String getSearchButtonText() {
        return $x("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']").getAttribute("value");
    }

    public WebElement getLogo() {
        return $x("//img[@width>'200']");
    }

    public boolean isLogoDisplayed() {
        return getLogo().isDisplayed();
    }

    public boolean isSearchBoxDisplayed() {
        return $(byName("q")).isDisplayed();
    }

    public boolean isSearchButtonDisplayed() {
        return $x("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']").isDisplayed();
    }
}
