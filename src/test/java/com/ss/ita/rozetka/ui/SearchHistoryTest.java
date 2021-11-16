package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.TestUtils.TestRunner;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.pages.ProductTypePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchHistoryTest extends TestRunner {

    @Test
    public void verifySearchHistoryText() {
        int numberSearchTerm = 1;
        String searchTerm = "DELL";
        String partOfUrl = "search";
        ProductTypePage productsList = new HomePage()
                .open()
                .getHeader()
                .doSearch(searchTerm);
        Assert.assertTrue(productsList
                        .getHeader()
                        .isUrlContainsText(partOfUrl),
                "Search Result didn't open");
        HomePage homePage = productsList
                .getHeader()
                .openHomePage();
        Assert.assertEquals(homePage
                        .getHeader()
                        .getCurrentUrl(),
                "https://rozetka.com.ua/",
                "Home Page didn't open");
        String actualSearchTerm = homePage
                .getHeader()
                .setSearchInputInFocus()
                .getTextFromSearchHistory(numberSearchTerm);
        Assert.assertEquals(actualSearchTerm, searchTerm);
   }
}
