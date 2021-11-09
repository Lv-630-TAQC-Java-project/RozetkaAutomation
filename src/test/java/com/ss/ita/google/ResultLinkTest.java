package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.SearchResultPage;
import com.ss.ita.google.ui.pages.runner.TestRunnerForGoogle;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ResultLinkTest extends TestRunnerForGoogle {

    @Test
    public void verifyOpenResultLink() {
        String searchTerm = "funny kitten";
        int numberResultLink = 5;
        SearchResultPage searchResultPage = new HomePage().doSearch(searchTerm);
        String resultLinkUrl = searchResultPage.getResultLinkUrl(numberResultLink);
        String pageUrl = searchResultPage.openSearchResultLink(numberResultLink).getUrl();
        assertEquals(resultLinkUrl, pageUrl);
    }
}
