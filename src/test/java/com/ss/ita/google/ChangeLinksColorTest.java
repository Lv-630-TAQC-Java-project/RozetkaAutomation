package com.ss.ita.google;

import com.ss.ita.google.ui.pages.*;
import com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.ss.ita.google.ui.pages.utils.Utils.*;
import static com.ss.ita.google.ui.pages.helper.HelperClass.*;
import static org.testng.Assert.*;

public class ChangeLinksColorTest extends TestRunner {

    //get needed WebElement to change his color
    private WebElement searchedResultLink(int numberOfSearchedResultLink) {
        return new SearchResultPage().getSearchedResultLink(numberOfSearchedResultLink);
    }

    @Test
    public void verifyChangingLinksColor() {
        int numberOfSearchedResultLink = 0;

        SearchResultPage searchResultPage = new HomePage()
                .doSearch("Funny kitten picture");
        String firstLinkText = searchResultPage
                .getLinkText(numberOfSearchedResultLink);
        String defaultColor = getWebElementColor(searchedResultLink(numberOfSearchedResultLink));
        setColorViaJs("lightpink", searchedResultLink(numberOfSearchedResultLink));
        String changedColor = getWebElementColor(searchedResultLink(numberOfSearchedResultLink));

        assertTrue(firstLinkText.contains("Kitten"));
        assertTrue(defaultColor != changedColor);
    }
}
