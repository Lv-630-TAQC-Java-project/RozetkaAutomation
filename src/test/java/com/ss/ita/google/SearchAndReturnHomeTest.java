package com.ss.ita.google;


import com.ss.ita.google.ui.pages.HomePage;

import com.ss.ita.google.ui.pages.SearchResultPage;
import com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchAndReturnHomeTest extends TestRunner {

    @Test
    public void verifyReturningHomePageAfterSearching() {
        new HomePage()
                .doSearch("funny kitten")
                .returnHomePage();
        assertTrue(driver.findElement(By.id("hplogo")).isDisplayed());
    }

    @Test
    public void verifySearchLinksContainsWord(){
        SearchResultPage searchResultPage = new HomePage()
                .doSearch("funny kitten");

        String word = "kitten";

        for (int i = 0; i < searchResultPage.getResultLinksText().size(); i++) {
            String linkText = searchResultPage.getLinkText(i).toLowerCase();
            assertTrue(linkText.contains(word));
        }
    }
}
