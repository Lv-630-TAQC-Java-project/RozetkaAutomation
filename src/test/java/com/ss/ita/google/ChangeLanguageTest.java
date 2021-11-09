package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.runner.TestRunnerForGoogle;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ChangeLanguageTest extends TestRunnerForGoogle {

    @Test
    public void verifyUserCanChangeLanguage() {
        HomePage homePage = new HomePage().changeLanguage("русский");
        String actualRuText = homePage.getSearchButtonText();
        String expectedRuText = "Поиск в Google";

        assertEquals(actualRuText, expectedRuText, "Language didn't change");

        homePage.changeLanguage("українська");
        String actualUaText = new HomePage().getSearchButtonText();
        String expectedUaText = "Пошук Google";

        assertEquals(actualUaText, expectedUaText, "Language didn't change");
    }
}