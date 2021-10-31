package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HideHomePageLogoTest extends TestRunner {
    @Test
    public void verifyHomePageLogoIsHidden(){
        HomePage page = new HomePage();

        Assert.assertTrue(page.isLogoDisplayed());

        page.hideLogo();

        Assert.assertFalse(page.isLogoDisplayed());

        page.displayLogo();
    }
}
