package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.runner.TestRunnerForGoogle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenSearchResultPageNineTest extends TestRunnerForGoogle {

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
