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

        String isHidden = logo.getAttribute("hidden");
        Assert.assertEquals(isHidden, "false");

        // How am I supposed to hide the Google logo?

        isHidden = logo.getAttribute("hidden");
        Assert.assertEquals(isHidden, "true");
    }
}
