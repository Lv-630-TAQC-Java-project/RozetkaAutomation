package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenSearchResultPageNineTest extends TestRunner {

    @Test
    public void verifyOpenPageNine() {
        int pageNumber = 9;
        new HomePage()
                .doSearch("funny kitten")
                .openSearchResultPageNumber(pageNumber)
                .shouldHavePageNumber(pageNumber);
    }
}
