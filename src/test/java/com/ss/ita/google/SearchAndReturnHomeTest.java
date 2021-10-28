package com.ss.ita.google;


import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.runner.TestRunner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchAndReturnHomeTest extends TestRunner {

    @Test
    public void verifyReturningHomePageAfterSearching() {
        new HomePage(driver)
                .doSearch("funny kitten")
                .returnHomePage();
        Assert.assertTrue(driver.findElement(By.id("hplogo")).isDisplayed());
    }
}
