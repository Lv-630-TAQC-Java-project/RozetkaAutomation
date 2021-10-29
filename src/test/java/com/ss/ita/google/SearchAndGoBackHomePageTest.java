package com.ss.ita.google;


import com.ss.ita.google.ui.pages.HomePage;

import com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchAndGoBackHomePageTest extends TestRunner {

    @Test
    public void verifyGoingBackToHomePageAfterSearching() {
        new HomePage()
                .doSearch("funny kitten")
                .goBackToHomePage();
        SoftAssert asert = new SoftAssert();
        asert.assertTrue(driver.findElement(By.xpath("//img")).isDisplayed()); //logo
        asert.assertTrue(driver.findElement(By.name("q")).isDisplayed()); //search field
        asert.assertAll();
    }
}
