package com.ss.ita.rozetka;

import com.ss.ita.rozetka.ui.pages.Header;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.runner.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class changeLanguageTest extends TestRunner {
    public void verifyUserCanChangeLanguage() {
        Header header = new HomePage().open();

        header.changeLanguage("UA");

        Assert.assertEquals(new HomePage().getGreetingsText(), "Ласкаво просимо!");

        header.changeLanguage("RU");

        Assert.assertEquals(new HomePage().getGreetingsText(), "Добро пожаловать!");
    }
}
