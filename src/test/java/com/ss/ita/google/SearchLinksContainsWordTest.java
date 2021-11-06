package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.SearchResultPage;
import com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SearchLinksContainsWordTest extends TestRunner {

    @Test
    public void verifySearchLinksContainsWord() {
        String word = "kitten";
        SearchResultPage searchResultPage = new HomePage().doSearch("funny kitten");
        List<String> resLinksTexts = searchResultPage.getResultLinksTexts();
        int numberOfLinks = resLinksTexts.size();
        assertTrue(numberOfLinks != 0);
        for (String  resultLink : resLinksTexts) {
            assertTrue(resultLink.contains(word));
        }
    }

    @Test
    public void verifyFivePageLinksContainsText() {
        String searchText = "funny kitten";
        int numberResultPage = 4;
        List<String> linksTexts = new HomePage()
                                    .doSearch(searchText)
                                    .openResultPage(numberResultPage)
                                    .getResultLinksTexts();
        String expectedText = "kitten";
        SoftAssert softAssert = new SoftAssert();
        for (String linkText : linksTexts) {
            softAssert.assertTrue(linkText.toLowerCase().contains(expectedText));
        }
        softAssert.assertAll();
    }
}
