package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.SearchResultPage;
import com.ss.ita.runner.TestRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
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
                .getLinksColor();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //  js.executeScript("document.querySelector('//div[@id='rso']//h3[contains(@class,'LC20lb')][1]').innerText=" +"pink");
        js.executeScript("document.querySelector('#rso > div:nth-child(26) > div > div:nth-child(1) > div > div > div > div.yuRUbf > a > h3').style.color = 'lightblue';");
        String changedColor = searchResultPage.getLinksColor();

        assertTrue(defaultColor != changedColor);

    }
}
