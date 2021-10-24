package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.SearchResultPage;
import com.ss.ita.runner.TestRunner;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class SearchTest extends TestRunner {

    @Test
    public void verifySearchTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String firstLinkText=new HomePage(driver)
                .search("funny kitten")
                .getLinkText(0);
        String expected = "99% Lose this TRY NOT TO LAUGH Challenge";
        assertEquals(firstLinkText, expected);
    }

    @Test
    public void verifySearchLinksContainsWord(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SearchResultPage resPage = new HomePage(driver)
                .search("funny kitten");
        CharSequence word = "kitten";
        for (int i = 0; i < 9; i++) {
            String linkText = resPage.getLinkText(i).toLowerCase();
            assertTrue(linkText.contains(word));
        }

    }
}
