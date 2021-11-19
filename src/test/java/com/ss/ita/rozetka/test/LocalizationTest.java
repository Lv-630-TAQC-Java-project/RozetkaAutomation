package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.elements.Header;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalizationTest extends TestRunner {

    @Test
    public void verifyUserCanChangeLanguage() {
        HomePage homePage = new HomePage().open();
        Header header = homePage.getHeader();

        header.changeLanguage("UA");

        assertThat(homePage.getGreetingsText())
                .as("Language should be changed")
                .contains("Ласкаво просимо!");

        header.changeLanguage("RU");

        assertThat(homePage.getGreetingsText())
                .as("Language should be changed")
                .contains("Добро пожаловать!");
    }
}