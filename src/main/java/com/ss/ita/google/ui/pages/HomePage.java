package com.ss.ita.google.ui.pages;

import static com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner.*;
import static com.ss.ita.google.ui.pages.utils.WebElementHelper.setAttribute;
import static com.ss.ita.google.ui.pages.utils.WebElementHelper.removeAttribute;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

    public SearchResultPage doSearch(String searchText) {
        return setSearchTerms(searchText).search();
    }

    public HomePage setSearchTerms(String terms) {
        WebElement input = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        input.clear();
        input.sendKeys(terms);
        return this;
    }

    public SearchResultPage search() {
        driver.findElement(By.xpath("//input[@class='gNO89b'][1]")).click();
        return new SearchResultPage();
    }

    public HomePage changeLanguage(String language) {
        driver.findElement((By.xpath("//a[contains(text(),'" + language + "')]"))).click();
        return this;
    }

    public String getSearchButtonText() {
        return driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")).getAttribute("value");
    }

    private WebElement getLogo() {
        return driver.findElement(By.xpath("//img[@width>'200']"));
    }

    public boolean isLogoDisplayed() {
        return getLogo().isDisplayed();
    }

    public HomePage hideLogo() {
        setAttribute(getLogo(), "hidden", "true");
        return this;
    }

    public HomePage displayLogo() {
        removeAttribute(getLogo(), "hidden");
        return this;
    }
}

