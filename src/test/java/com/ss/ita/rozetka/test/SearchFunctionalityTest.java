package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.elements.Header;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.ProductTypePage;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.sleep;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchFunctionalityTest extends TestRunner {

    @Test
    @Description("Verify that user can do search with Xiaomi products")
    @TmsLink(value = "LVTAQC630-10")
    public void verifyXiaomiWillBeInSearchResult() {
        String searchProduct = "Xiaomi";

        ProductTypePage productTypePage = new HomePage()
                .open()
                .getHeader()
                .doSearch(searchProduct);

        assertThat(productTypePage.getProductTitle(1))
                .as("Product should have Xiaomi in title")
                .contains(searchProduct);
    }

    @Test
    @TmsLink(value = "LVTAQC630-4")
    @Description(value = "Verify that searched product was added to search history")
    public void verifySearchHistoryText() {
        var header = new HomePage()
                .open()
                .getHeader();
        var searchTerm = "DELL";
        var searchResultPage = header.doSearch(searchTerm);
        assertThat(searchResultPage.isSelectSortingTypeDisplayed())
                .as("Select sorting type should be displayed")
                .isTrue();
        var homePage = header.openHomePage();
        assertThat(homePage.isMainMenuCategoriesDisplayed())
                .as("Main Menu Categories should be displayed")
                .isTrue();
        int numberSearchTerm = 1;
        var actualSearchTerm = header
                .setSearchInputInFocus()
                .getTextFromSearchHistory(numberSearchTerm);
        assertThat(actualSearchTerm)
                .as("Last search term and first text in search history should be equals")
                .isEqualTo(searchTerm);
    }
}
