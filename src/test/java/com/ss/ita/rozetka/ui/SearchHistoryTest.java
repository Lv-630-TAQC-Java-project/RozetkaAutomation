package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.TestUtils.TestRunner;
import com.ss.ita.rozetka.ui.elements.Header;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.pages.ProductTypePage;
import com.ss.ita.rozetka.ui.util.PageUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        Assert.assertTrue(PageUtil
                        .getCurrentUrl()
                        .contains(partOfUrl),
                "Search Result should be open");
        headerPage.openHomePage();
        Assert.assertEquals(PageUtil.getCurrentUrl(), "https://rozetka.com.ua/",
                "Home Page should be open");
        String actualSearchTerm = headerPage
                .setSearchInputInFocus()
                .getTextFromSearchHistory(numberSearchTerm);
        Assert.assertEquals(actualSearchTerm, searchTerm);
    }
}
