package com.ss.ita.google;

import com.ss.ita.google.ui.elements.Image;
import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.runner.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyGoogleLogoNotDisplayed extends TestRunner {
    @Test
    public void verify() {
        Image logo = new HomePage(driver)
                .getGoogleLogo();

        Assert.assertEquals(logo.getCssValue("display"), "inline");

        logo.setAttribute("hidden", "true");

        Assert.assertEquals(logo.getCssValue("display"), "none");
    }
}
