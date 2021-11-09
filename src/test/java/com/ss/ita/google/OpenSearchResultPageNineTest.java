package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenSearchResultPageNineTest extends TestRunner {

    @Test
    public void verifyOpenPageNine() {
        int pageNumber = 9;
        int currentPageNumber = new HomePage()
                .doSearch("funny kitten")
                .openSearchResultPage(pageNumber)
                .getCurrentPageNumber();
        Assert.assertEquals(currentPageNumber, pageNumber);
    }
}
