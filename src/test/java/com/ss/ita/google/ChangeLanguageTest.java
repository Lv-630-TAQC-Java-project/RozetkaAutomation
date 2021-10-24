package com.ss.ita.google;

import com.ss.ita.google.ui.locators.HomePageLocator;
import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.runner.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ss.ita.google.ui.elements.Label;

import java.util.concurrent.TimeUnit;

public class ChangeLanguageTest extends TestRunner {
    @Test
    public void changeLanguageTest() {
        HomePage homePage = new HomePage(driver).changeLanguageToUa();
        String actualUa = driver.findElement(HomePageLocator.LANGUAGE_TEXT_AREA.getPath()).getText();

        Assert.assertEquals(actualUa, "Мова Google: русский", "Language didn't change");

        homePage.changeLanguageToRu();
        String actualRu = driver.findElement(HomePageLocator.LANGUAGE_TEXT_AREA.getPath()).getText();

        Assert.assertEquals(actualRu, "Сервисы Google доступны на разных языках: українська",
                "Language didn't change");
    }
}