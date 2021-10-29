package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoToResultPageNineTest extends TestRunner {

    @Test
    public void verifyGoToPageNine() {
        int pageNumber = 9;
        String currentPageNumber = new HomePage()
                .doSearch("funny kitten")
                .goToResultPageNumber(pageNumber)
                .getCurrentPageNumber();
        Assert.assertEquals(currentPageNumber, String.valueOf(pageNumber));
        }
}
