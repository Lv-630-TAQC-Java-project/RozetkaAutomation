package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.SearchResultPage;
import com.ss.ita.google.ui.pages.runner.TestRunner;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ChangeLinksColorTest extends TestRunner {

    @Test
    public void verifyChangeLinksColorTest() {
        String searchText = "Funny kitten picture";

        SearchResultPage searchResultPage = new HomePage()
                .doSearch("Funny kitten picture");
        String firstLinkText = searchResultPage
                .getLinkText(0);
        String defaultColor = searchResultPage
                .getLinkColor(0);
        searchResultPage.changeFirstLinkColor("lightpink");
        String changedColor = searchResultPage
                .getLinkColor(0);

        assertTrue(firstLinkText.contains("Funny"));
        assertTrue(defaultColor != changedColor);

    }
}
