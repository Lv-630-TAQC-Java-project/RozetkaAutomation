package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.runner.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchHistoryTest extends TestRunner {

    @Test
    public void verifySearchHistoryText() {
        int numberSearchTerm = 1;
        String searchTerm = "DELL";
        String actualTerm = new HomePage()
                .open()
                .getHeader()
                .doSearch(searchTerm)
                .getHeader()
                .openHomePage().getHeader()
                .setFocusSearchInput()
                .getTextFromSearchHistory(numberSearchTerm);
        Assert.assertEquals(actualTerm, searchTerm);
    }
}
