package com.ss.ita.google.ui.pages;

import com.ss.ita.google.ui.elements.Button;
import com.ss.ita.google.ui.elements.Label;
import com.ss.ita.google.ui.elements.Link;
import com.ss.ita.google.ui.elements.TextArea;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.ss.ita.google.ui.locators.HomePageLocator.*;

public class HomePage extends BasePage {
    private TextArea search;
    private Button searchButton;
    private Link ruLanguage;
    private Link uaLanguage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage search(String searchText) {
        setSearchText(searchText)
                .clickSearchButton();

        return new SearchResultPage(driver);
    }

    public HomePage clickSearchButton() {
        getSearchButton().clickButton();
        return this;
    }

    public Button getSearchButton() {
        if (searchButton == null) {
            searchButton = new Button(driver, SEARCH_BUTTON);
        }
        return searchButton;
    }

    public HomePage setSearchText(String searchText) {
        getSearchTextArea().sendKeysTextArea(searchText);
        return this;
    }

    public HomePage clickSearchTextArea() {
        getSearchTextArea().clickTextArea();
        return this;
    }

    public HomePage clearSearchTextArea() {
        getSearchTextArea().clearTextArea();
        return this;
    }

    public TextArea getSearchTextArea() {
        if (search == null) {
            search = new TextArea(driver, SEARCH_TEXT_AREA);
        }

        return search;
    }

    public HomePage changeLanguageToRu() {
        driver.findElement(By.xpath("//a[contains(text(),'русский')]")).click();
        return this;
    }

    public HomePage changeLanguageToUa() {
       driver.findElement((By.xpath("//a[contains(text(),'українська')]"))).click();
        return this;
    }
}
