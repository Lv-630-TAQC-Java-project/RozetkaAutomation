package com.ss.ita.google;

import com.ss.ita.google.ui.pages.*;
import com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.ss.ita.google.ui.pages.util.WebElementUtil.*;
import static org.testng.Assert.*;

public class ChangeLinksColorTest extends TestRunner {
    // method to get link needed in test
    private WebElement searchedResultLink(SearchResultPage searchResultPage) {
        return searchResultPage.getSearchedResultLink(0);
    }
    
    @Test
    public void verifyChangingLinksColor() {
        SearchResultPage searchResultPage = new HomePage()
                .doSearch("Funny kitten picture");
        String firstLinkText = searchResultPage
                .getSearchedResultLinkText(0);
        String defaultColor = getColor(searchedResultLink(searchResultPage));
        setColorViaJs(searchedResultLink(searchResultPage), "lightpink");
        String changedColor = getColor(searchedResultLink(searchResultPage));

        assertTrue(firstLinkText.contains("Kitten"));
        assertTrue(defaultColor != changedColor);
    }
}
