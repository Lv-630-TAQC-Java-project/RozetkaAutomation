package com.ss.ita.google.ui.pages;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.*;

public class SearchResultPage {

    private String resultLinkLocator = "(//div[@class='yuRUbf']/a)[%s]";

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

    public List<String> getResultLinksTexts() {
        return $$x("//h3[contains(@class,'LC20lb')]").stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public WebElement getSearchedResultLink(int numberOfLink) {
        return $$x("//div[@id='rso']//h3[contains(@class,'LC20lb')]").get(numberOfLink);
    }

    public HomePage goBackToHomePage() {
        $x("//a/img").click();
        return new HomePage();
    }

    public SearchedPage openSearchResultLink(int numberResultLink) {
        $x(String.format(resultLinkLocator, numberResultLink)).click();
        return new SearchedPage();
    }

    public String getResultLinkUrl(int numberResultLink) {
        return $x(String.format(resultLinkLocator, numberResultLink)).getAttribute("href");
    }

    public SearchResultPage openSearchResultPage(int pageNumber) {
        $x(String.format("//a[@aria-label = 'Page %s']", pageNumber)).click();
        return this;
    }

    public SearchResultPage shouldHavePageNumber(int number) {
        $x("//td[text()]").shouldHave(text(Integer.toString(number)));
        return this;
    }
}
