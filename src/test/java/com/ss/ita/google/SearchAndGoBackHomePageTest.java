package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;

import com.ss.ita.google.ui.runner.TestRunnerForGoogle;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchAndGoBackHomePageTest extends TestRunnerForGoogle {

    @Test
    public void verifyGoingBackToHomePageAfterSearching() {
        HomePage homePage = new HomePage()
                .doSearch("funny kitten")
                .goBackToHomePage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isLogoDisplayed());
        softAssert.assertTrue(homePage.isSearchBoxDisplayed());
        softAssert.assertTrue(homePage.isSearchButtonDisplayed());
        softAssert.assertAll();
    }
}
