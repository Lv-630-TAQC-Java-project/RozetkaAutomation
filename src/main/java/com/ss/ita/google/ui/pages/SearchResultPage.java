package com.ss.ita.google.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BasePage {


    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

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

    public String getLinkText(int numberOfLink) {
        return getSearchedLink(numberOfLink).getText();
    }

    public String getLinkColor(int numberOfLink) {
        return getSearchedLink(numberOfLink).getCssValue("color");
    }

    public WebElement getSearchedLink(int numberOfLink) {
        return driver.findElements(By.xpath("//div[@id='rso']//h3[contains(@class,'LC20lb')]")).get(numberOfLink);
    }

    public SearchResultPage returnHomePage() {
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[1]/div[1]/div[1]/a/img")).click();
        return this;
    }
}
