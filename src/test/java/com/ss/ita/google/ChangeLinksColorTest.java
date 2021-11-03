package com.ss.ita.google;

import com.ss.ita.google.ui.pages.*;
import com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner;
import org.testng.annotations.Test;

import static com.ss.ita.google.ui.pages.util.WebElementUtil.*;
import static org.testng.Assert.*;

public class ChangeLinksColorTest extends TestRunner {

    @Test
    public void verifyChangingLinksColor() {
        int numberOfSearchedResultLink = 0; //first link to get text and color.

        SearchResultPage searchResultPage = new HomePage()
                .doSearch("Funny kitten picture");
        String firstLinkText = searchResultPage
                .getSearchedResultLinkText(numberOfSearchedResultLink);
        String defaultColor = getColor(searchResultPage.getSearchedResultLink(numberOfSearchedResultLink));
        setColorViaJs(searchResultPage.getSearchedResultLink(numberOfSearchedResultLink), "lightpink");
        String changedColor = getColor(searchResultPage.getSearchedResultLink(numberOfSearchedResultLink));

        assertTrue(firstLinkText.contains("Kitten"));
        assertTrue(defaultColor != changedColor);
    }
}
