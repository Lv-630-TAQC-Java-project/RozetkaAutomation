package com.ss.ita.google;

import com.ss.ita.google.ui.pages.*;
import com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.ss.ita.google.ui.pages.util.WebElementUtil.*;
import static org.testng.Assert.*;

public class ChangeLinksColorTest extends TestRunner {

    @Test
    public void verifyChangingLinksColor() {
        SearchResultPage searchResultPage = new HomePage().doSearch("Funny kitten picture");
        WebElement searchedResultLink = searchResultPage.getSearchedResultLink(0);
        String firstLinkText = searchResultPage.getSearchedResultLinkText(0);
        String defaultColor = getColor(searchedResultLink);
        setColorViaJs(searchedResultLink, "lightpink");
        String changedColor = getColor(searchedResultLink);
        assertTrue(firstLinkText.contains("Kitten"));
        assertTrue(defaultColor != changedColor);
    }
}
