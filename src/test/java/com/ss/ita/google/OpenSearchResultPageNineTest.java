package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.runner.TestRunnerForGoogle;
import org.testng.annotations.Test;

public class OpenSearchResultPageNineTest extends TestRunnerForGoogle {

    @Test
    public void verifyOpenPageNine() {
        int pageNumber = 9;
        new HomePage()
                .doSearch("funny kitten")
                .openSearchResultPage(pageNumber)
                .shouldHavePageNumber(pageNumber);
    }
}
