package com.ss.ita.google.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage {

    public SearchResultPage doSearch(String searchText) {
        setSearchTerms(searchText).search();
        return this;
    }

    public SearchResultPage search() {
        driver.findElement(By.xpath("//button[@class = 'Tg7LZd']")).click();
        return this;
    }

    public SearchResultPage setSearchTerms(String searchText) {
        WebElement searchField = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
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
        return driver.findElements(By.xpath("//div[@id='rso']//h3[contains(@class,'LC20lb')]")).get(numberOfLink);
    }

    public HomePage goBackToHomePage() {
        driver.findElement(By.xpath("//a/img")).click();
        return new HomePage();
    }

    public SearchedPage openSearchResultLink(int numberResultLink) {
        getSearchedResultLink(numberResultLink).click();
        return new SearchedPage();
    }

    public String getResultLinkUrl(int numberResultLink) {
        return getSearchedResultLink(numberResultLink).getAttribute("href");
    }

    public SearchResultPage openResultPage(int pageNumber) {
        $x(String.format("//a[@aria-label = 'Page %s']", pageNumber)).click();
        return this;
    }

    public int getCurrentPageNumber() {
        return Integer.parseInt($x("//td[text()]").getText());
    }
}
