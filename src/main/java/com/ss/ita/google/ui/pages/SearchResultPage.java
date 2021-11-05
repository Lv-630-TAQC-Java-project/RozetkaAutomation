package com.ss.ita.google.ui.pages;

import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.Integer.parseInt;

public class SearchResultPage {

    public SearchResultPage doSearch(String searchText) {
        setSearchTerms(searchText).search();
        return this;
    }

    public SearchResultPage search() {
        $x("//button[@class = 'Tg7LZd']").click();
        return this;
    }

    public SearchResultPage setSearchTerms(String searchText) {
        WebElement searchField = $x("//input[@class='gLFyf gsfi']");
        searchField.clear();
        searchField.sendKeys(searchText);
        return this;
    }

    public String getSearchedResultLinkText(int numberOfLink) {
        return getSearchedResultLink(numberOfLink).getText();
    }


    public WebElement getSearchedResultLink(int numberOfLink) {
        return $$x("//h3[contains(@class,'LC20lb')]").get(numberOfLink);
    }

    public HomePage goBackToHomePage() {
        $x("//a/img").click();
        return new HomePage();
    }

    public SearchedPage openSearchResultLink(int numberOfResultLink) {
       getSearchedResultLink(numberOfResultLink).click();
        return new SearchedPage();
    }

    public String getSearchedResultLinkUrl(int numberOfResultLink) {
        return getSearchedResultLink(numberOfResultLink)
                        .getAttribute("href");
    }
//?
    public SearchResultPage openResultPage(int pageNumber) {
       $x(String.format("//a[@aria-label = 'Page %s']", pageNumber)).click();
        return this;
    }

    public int getCurrentPageNumber() {
        return parseInt($x("//td[text()]").getText());
    }
}
