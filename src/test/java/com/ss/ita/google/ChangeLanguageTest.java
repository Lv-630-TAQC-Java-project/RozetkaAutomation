package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.runner.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ChangeLanguageTest extends TestRunner {

    @Test
    public void changeLanguageTest() {
        HomePage homePage = new HomePage(driver).changeLanguageToUa();
        String actualUaLanguage = new HomePage(driver).languageTextArea();

        Assert.assertEquals(actualUaLanguage, "Мова Google: русский", "Language didn't change");

        homePage.changeLanguageToRu();
        String actualRuLanguage = new HomePage(driver).languageTextArea();

        Assert.assertEquals(actualRuLanguage, "Сервисы Google доступны на разных языках: українська",
                "Language didn't change");
    }
}