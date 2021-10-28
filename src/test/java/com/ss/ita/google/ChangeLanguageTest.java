package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.runner.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ChangeLanguageTest extends TestRunner {

    @Test
    public void verifyUserCanChangeLanguage() {
        HomePage homePage = new HomePage(driver).changeLanguage("русский");
        String actualRuText = homePage.getSearchButtonText();
        String expectedRuText = "Поиск в Google";

        Assert.assertEquals(actualRuText, expectedRuText, "Language didn't change");

        homePage.changeLanguage("українська");
        String actualUaText = new HomePage(driver).getSearchButtonText();
        String expectedUaText = "Пошук Google";

        Assert.assertEquals(actualUaText, expectedUaText, "Language didn't change");
    }
}