package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenResultPageNineTest extends TestRunner {

    @Test
    public void verifyOpenPageNine() {
        var pageNumber = 9;
        var currentPageNumber = new HomePage()
                .doSearch("funny kitten")
                .openResultPage(pageNumber)
                .getCurrentPageNumber();
        Assert.assertEquals(currentPageNumber, pageNumber);
    }
}
