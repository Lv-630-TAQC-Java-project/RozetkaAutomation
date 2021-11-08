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
}
