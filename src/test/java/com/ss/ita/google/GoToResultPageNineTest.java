package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoToResultPageNineTest extends TestRunner {

    @Test
    public void verifyGoToPageNine() {
        Assert.assertEquals(new HomePage()
                .doSearch("funny kitten")
                .goToResultPageNumber(9)
                .getCurrentPageNumber(), "9");
        }
}
