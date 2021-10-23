package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.SearchResultPage;
import com.ss.ita.runner.TestRunner;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class SearchTest extends TestRunner {

    @Test
    public void firstTest(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SearchResultPage searchResultPage = new HomePage(driver)
                .search("Funny kitten");
    }
}
