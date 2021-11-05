package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.SearchResultPage;
import org.testng.annotations.Test;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class SearchLinksContainsWordTest {

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
