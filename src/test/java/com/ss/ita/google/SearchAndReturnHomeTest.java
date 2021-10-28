package com.ss.ita.google;


import com.ss.ita.google.ui.pages.HomePage;

import com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchAndReturnHomeTest extends TestRunner {

    @Test
    public void verifyReturningHomePageAfterSearching() {
        new HomePage()
                .doSearch("funny kitten")
                .backToHomePage();
        assertTrue(driver.findElement(By.id("hplogo")).isDisplayed());
    }
}
