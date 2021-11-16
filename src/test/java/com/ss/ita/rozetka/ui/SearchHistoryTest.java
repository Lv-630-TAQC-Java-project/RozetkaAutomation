package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.TestUtils.TestRunner;
import com.ss.ita.rozetka.ui.elements.Header;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.pages.ProductTypePage;
import com.ss.ita.rozetka.ui.util.PageUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchHistoryTest extends TestRunner {

    @Test
    public void verifySearchHistoryText() {
        int numberSearchTerm = 1;
        String searchTerm = "DELL";
        String partOfUrl = "search";
        Header headerPage = new HomePage()
                .open()
                .getHeader();
        headerPage.doSearch(searchTerm);
        assertThat(PageUtil.getCurrentUrl())
                .as("Search Result should be opened")
                .contains(partOfUrl);
        headerPage.openHomePage();
        assertThat(PageUtil.getCurrentUrl())
                .as("Home Page should be opened")
                .isEqualTo("https://rozetka.com.ua/");
        String actualSearchTerm = headerPage
                .setSearchInputInFocus()
                .getTextFromSearchHistory(numberSearchTerm);
        assertThat(actualSearchTerm).isEqualTo(searchTerm);
    }
}
