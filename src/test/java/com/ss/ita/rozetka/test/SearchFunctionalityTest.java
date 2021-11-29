package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.elements.Header;
import com.ss.ita.rozetka.pageobject.elements.Product;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.ProductTypePage;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.sleep;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchFunctionalityTest extends TestRunner {

    @Test
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
    public void verifySearchHistoryTest() {
        Header header = new HomePage()
                .open()
                .getHeader();
        String searchTerm = "DELL";
        ProductTypePage searchResultPage = header.doSearch(searchTerm);
        assertThat(searchResultPage.isSelectSortingTypeDisplayed())
                .as("Select sorting type should be displayed")
                .isTrue();
        HomePage homePage = header.openHomePage();
        assertThat(homePage.isMainMenuCategoriesDisplayed())
                .as("Main Menu Categories should be displayed")
                .isTrue();
        int numberSearchTerm = 1;
        String actualSearchTerm = header
                .setSearchInputInFocus()
                .getTextFromSearchHistory(numberSearchTerm);
        assertThat(actualSearchTerm)
                .as("Last search term and first text in search history should be equals")
                .isEqualTo(searchTerm);
    }

    @Test
    @Description("Verify that items in the search history in right order and search works correct")
    public void verifySearchFromSearchHistoryTest() {
        Header header = new HomePage()
                .open()
                .getHeader();
        List<String> searchTerms = new ArrayList<>(Arrays.asList("Dell", "НР", "IPhone", "Stihl"));
        Product productItem;
        ProductTypePage searchResultPage;
        for (String searchTerm : searchTerms){
            searchResultPage = header.doSearch(searchTerm);
            for (int i = 1; i <= $$x("//div[@class='goods-tile__inner']").size(); i++){
                productItem = searchResultPage.getProduct(i);
                assertThat(productItem
                        .getProductTitle()
                        .toUpperCase())
                        .as("Product title should contains search term")
                        .contains(searchTerm.toUpperCase());
            }
            header.openHomePage();
        }
        header.setSearchInputInFocus();
    }
}
