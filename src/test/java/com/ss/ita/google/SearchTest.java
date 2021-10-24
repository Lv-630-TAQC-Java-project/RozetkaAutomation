package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.SearchResultPage;
import com.ss.ita.runner.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class SearchTest extends TestRunner {

    @Test
    public void firstTest(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String actual = new HomePage(driver)
                .search("Funny kitten")
                .getResultLinks()
                .get(0)
                .getText();

        String expected = "99% Lose this TRY NOT TO LAUGH Challenge";
        Assert.assertEquals(actual, expected);
    }
}
