package com.ss.ita.google;

import com.ss.ita.google.ui.pages.*;
import com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner;
import org.testng.annotations.Test;

import static com.ss.ita.google.ui.pages.helper.HelperClass.*;
import static org.testng.Assert.*;

public class ChangeLinksColorTest extends TestRunner {

    @Test
    public void verifyChangingLinksColor() {
        SearchResultPage searchResultPage = new HomePage()
                .doSearch("Funny kitten picture");
        String firstLinkText = searchResultPage
                .getLinkText(0);
        String defaultColor = searchResultPage
                .getLinkColor(0);
        setColorViaJs("lightpink", searchResultPage.getSearchedLink(0));
        String changedColor = searchResultPage
                .getLinkColor(0);

        assertTrue(firstLinkText.contains("Kitten"));
        assertTrue(defaultColor != changedColor);
    }
}
