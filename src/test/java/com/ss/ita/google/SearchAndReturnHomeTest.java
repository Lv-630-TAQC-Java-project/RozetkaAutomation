package com.ss.ita.google;


import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.runner.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import  com.ss.ita.google.ui.locators.HomePageLocator;

public class SearchAndReturnHomeTest extends TestRunner {

    @Test
    public void searchAndReturnHomePageTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        new HomePage(driver)
                .search("funny kitten")
                .returnHomePage();
        Assert.assertTrue(driver.findElement(HomePageLocator.GOOGLE_TITLE_IMAGE.getPath()).isDisplayed());
    }

}
