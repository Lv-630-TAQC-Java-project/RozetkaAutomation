package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner;
import static com.ss.ita.google.ui.pages.utils.WebElementHelper.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HideHomePageLogoTest extends TestRunner {
    @Test
    public void verifyHomePageLogoIsHidden() {
        HomePage page = new HomePage();
        Assert.assertTrue(page.isLogoDisplayed());

        switchWebElementVisibility(page.getLogo(), true);
        Assert.assertFalse(page.isLogoDisplayed());

        switchWebElementVisibility(page.getLogo(), false);
        Assert.assertTrue(page.isLogoDisplayed());
    }
}
