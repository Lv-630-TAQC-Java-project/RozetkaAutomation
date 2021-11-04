package com.ss.ita.google;

import com.ss.ita.google.ui.pages.HomePage;
import com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner;
import static com.ss.ita.google.ui.pages.util.WebElementUtil.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HideHomePageLogoTest extends TestRunner {
    @Test
    public void verifyHomePageLogoIsHidden() {
        HomePage page = new HomePage();
        Assert.assertTrue(page.isLogoDisplayed());

        setVisibility(page.getLogo(), true);
        Assert.assertFalse(page.isLogoDisplayed());

        setVisibility(page.getLogo(), false);
        Assert.assertTrue(page.isLogoDisplayed());
    }
}
