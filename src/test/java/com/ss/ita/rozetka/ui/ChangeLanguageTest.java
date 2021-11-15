package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.runner.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeLanguageTest extends TestRunner {

    @Test
    public void verifyUserCanChangeLanguage() {
        HomePage homePage = new HomePage().open();

        homePage.getHeader().changeLanguage("UA");

        Assert.assertEquals(homePage
                .getGreetingsText(), "Ласкаво просимо!", "Language wasn't changed");

        homePage.getHeader().changeLanguage("RU");

        Assert.assertEquals(homePage
                .getGreetingsText(), "Добро пожаловать!", "Language wasn't changed");
    }
}
