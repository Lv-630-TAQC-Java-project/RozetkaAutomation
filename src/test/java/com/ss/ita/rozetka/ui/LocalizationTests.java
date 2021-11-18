package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.TestUtils.TestRunner;
import com.ss.ita.rozetka.ui.elements.Header;
import com.ss.ita.rozetka.ui.pages.HomePage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalizationTests extends TestRunner {

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
