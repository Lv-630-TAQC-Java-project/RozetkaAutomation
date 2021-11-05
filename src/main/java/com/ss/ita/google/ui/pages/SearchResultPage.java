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
        return driver.findElements(By.xpath("//h3[contains(@class,'LC20lb')]"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public WebElement getSearchedResultLink(int numberOfLink) {
        return $$x("//div[@id='rso']//h3[contains(@class,'LC20lb')]").get(numberOfLink);
    }

    public HomePage goBackToHomePage() {
        driver.findElement(By.xpath("//a/img")).click();
        return new HomePage();
    }

    public SearchedPage openSearchResultLink(int numberResultLink) {
        driver.findElement(By.xpath(String.format("(//div[@class='yuRUbf']/a)[%s]", numberResultLink))).click();
        return new SearchedPage();
    }

    public String getResultLinkUrl(int numberResultLink) {
        return driver.findElement(By.xpath(String.format("(//div[@class='yuRUbf']/a)[%s]", numberResultLink)))
                        .getAttribute("href");
    }

    public SearchResultPage openResultPage(int pageNumber) {
        driver.findElement(By.xpath(String.format("//a[@aria-label = 'Page %s']", pageNumber))).click();
        return this;
    }

    public int getCurrentPageNumber() {
        return Integer.parseInt(driver.findElement(By.xpath("//td[text()]")).getText());
    }
}
