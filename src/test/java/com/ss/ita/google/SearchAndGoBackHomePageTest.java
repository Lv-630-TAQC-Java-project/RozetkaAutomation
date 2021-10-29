package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;

import com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchAndGoBackHomePageTest extends TestRunner {

    @Test
    public void verifyGoingBackToHomePageAfterSearching() {
        HomePage homePage = new HomePage()
                .doSearch("funny kitten")
                .goBackToHomePage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.logoIsDisplayed());
        softAssert.assertTrue(homePage.searchBoxDisplayed());
        softAssert.assertAll();
    }
}
