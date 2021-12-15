package com.ss.ita.rozetka.pageobject.pages;

import com.codeborne.selenide.SelenideElement;
import com.ss.ita.rozetka.pageobject.elements.Header;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class HelpCenterPage {

    @Step("HelpCenterPage: set search text {searchText}")
    private HelpCenterPage setSearchText(String searchText){
        SelenideElement searchField = $x("//input[@type='search']");
        searchField.clear();
        searchField.click();
        searchField.sendKeys(searchText);
        return this;
    }

    @Step("HelpCenterPage: do search of term")
    public HelpCenterSearchedPage doSearch(String searchText){
        setSearchText(searchText);
        $x("//input[@type='submit']").click();
        return new HelpCenterSearchedPage();
    }
}
