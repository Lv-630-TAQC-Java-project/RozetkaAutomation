package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.SearchResultPage;
import com.ss.ita.runner.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;
import java.util.concurrent.TimeUnit;

public class OpenResultPageNineTest extends TestRunner {

    @Test
    public void verifyPageNineTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        SearchResultPage searchResultPage = new HomePage(driver)
                .search("funny kitten");
        String link = searchResultPage.getPageNine().getLink();
        searchResultPage
                .getPageNine()
                .click();
        Assert.assertTrue(driver.getCurrentUrl().contains(link));
    }
}
