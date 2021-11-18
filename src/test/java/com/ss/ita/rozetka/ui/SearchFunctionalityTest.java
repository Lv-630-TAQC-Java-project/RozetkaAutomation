package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.TestUtils.TestRunner;
import com.ss.ita.rozetka.ui.elements.Header;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.pages.ProductTypePage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchFunctionalityTest extends TestRunner {

    @Test
    public void verifySearchHistoryText() {
        Header headerPage = new HomePage()
                .open()
                .getHeader();
        String searchTerm = "DELL";
        ProductTypePage productsList = headerPage.doSearch(searchTerm);
        assertThat(productsList.isSelectSortingTypeDisplayed())
                .as("Select sorting type should be displayed")
                .isTrue();
        HomePage homePage = headerPage.openHomePage();
        assertThat(homePage.isMainMenuCategoriesDisplayed())
                .as("Main Menu Categories should be displayed")
                .isTrue();
        int numberSearchTerm = 1;
        String actualSearchTerm = headerPage
                .setSearchInputInFocus()
                .getTextFromSearchHistory(numberSearchTerm);
        assertThat(actualSearchTerm)
                .as("Last search term and first text in search history should be equals")
                .isEqualTo(searchTerm);
    }
}
