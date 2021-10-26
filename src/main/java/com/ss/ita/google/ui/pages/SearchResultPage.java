package com.ss.ita.google.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BasePage {
    private final static String SEARCH_FIELD = ("//input[@class='gLFyf gsfi']");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage doSearch(String searchText) {
        setSearchTerm(searchText);
        search();
        return this;
    }

    public SearchResultPage search() {
        driver.findElement(By.xpath("//button[@class = 'Tg7LZd']")).click();
        return this;
    }

    public SearchResultPage setSearchTerm(String searchText) {
        driver.findElement(By.xpath(SEARCH_FIELD)).clear();
        driver.findElement(By.xpath(SEARCH_FIELD)).sendKeys(searchText);
        return this;
    }

    public String getLinkText(int numberOfLink) {
        return getSearchedLink(numberOfLink).getText();
    }

    public String getLinkColor(int numberOfLink) {
        return getSearchedLink(numberOfLink).getCssValue("color");
    }

    public WebElement getSearchedLink(int numberOfLink) {
           return driver.findElements(By.xpath("//div[@id='rso']//h3[contains(@class,'LC20lb')]")).get(numberOfLink);
    }
}
