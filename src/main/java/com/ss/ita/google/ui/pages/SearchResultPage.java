package com.ss.ita.google.ui.pages;

import com.ss.ita.google.ui.elements.Button;
import com.ss.ita.google.ui.elements.Link;
import com.ss.ita.google.ui.elements.TextArea;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

import static com.ss.ita.google.ui.locators.HomePageLocator.SEARCH_BUTTON;
import static com.ss.ita.google.ui.locators.SearchResultPageLocator.*;

public class SearchResultPage extends BasePage {
    private TextArea searchField;
    private Button searchButton;
    private Link pageNine;

    private List<Link> resultLinks;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getLinkText(int numberOfLink) {
        return new SearchResultPage(driver)
                .getLink(numberOfLink)
                .getText();
    }

    public String getLinksColor() {
        return driver.findElement(LINKS_LIST.getPath()).getAttribute("color");
    }

    public TextArea getSearchField() {
        if (searchField == null) searchField = new TextArea(driver, SEARCH_TEXT_FIELD);
        return searchField;
    }

    public Button getSearchButton() {
        if (searchButton == null) searchButton = new Button(driver, SEARCH_BUTTON);
        return searchButton;
    }

    public Link getLink(int numberOfLink){
      return getResultLinks()
                .get(numberOfLink);
    }

    public List<Link> getResultLinks() {
        if (resultLinks == null)
            resultLinks = driver.findElements(LINKS_LIST.getPath()).stream()
                    .map(Link::new)
                    .collect(Collectors.toList());

        return resultLinks;
    }

    public SearchResultPage setSearchText(String searchText) {
        getSearchField().sendKeysTextArea(searchText);
        return this;
    }

    public SearchResultPage clickSearch() {
        getSearchButton().clickButton();
        return new SearchResultPage(driver);
    }

    public SearchResultPage search(String text) {
        return
                setSearchText(text)
                        .clickSearch();
    }

    public SelectedWebSite goToLink(int index) {
        getResultLinks().get(index).click();
        return new SelectedWebSite(driver);
    }

    public Link getPageNine() {
        if (pageNine == null) {
            pageNine = new Link(driver, PAGE_NINE_LINK);
        }
        return pageNine;
    }
}
