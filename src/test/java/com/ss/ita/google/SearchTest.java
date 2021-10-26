package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.SearchResultPage;
import com.ss.ita.runner.TestRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class SearchTest extends TestRunner {

    @Test
    public void verifyChangeColorTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String searchText = "funny kitten picture";

        SearchResultPage searchResultPage = new HomePage(driver)
                .search(searchText);
        String firstLinkText = searchResultPage
                .getLinkText(0);

//        assertTrue(firstLinkText.contains(searchText));

        String defaultColor = searchResultPage
                .getFirstLinkColor();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('.g>div>div>div>a>h3').style.color = 'lightpink';");
        String changedColor = searchResultPage
                .getFirstLinkColor();

        assertTrue(defaultColor != changedColor);

    }
}
