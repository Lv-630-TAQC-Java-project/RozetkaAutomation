package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.Modals.SideMenuModal;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.runner.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SideMenuModalTest extends TestRunner {

    @Test
    public void verifyOpenCloseSideMenuModal() {
        HomePage homePage = new HomePage().open();
        SideMenuModal menu = homePage.getHeader().openSideMenuModal();
        Assert.assertTrue(homePage
                            .getHeader()
                            .isVisibleSideMenuModal(),
                "Side Menu have to be visible but is invisible");
        menu.closeSideMenuModal();
        Assert.assertFalse(homePage
                            .getHeader()
                            .isVisibleSideMenuModal(),
                "Side Menu have to be invisible but is visible");
    }
}
