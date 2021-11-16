package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.Modals.SideModalMenu;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.runner.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SideModalMenuTest extends TestRunner {

    @Test
    public void verifyOpenCloseSideModalMenu() {
        HomePage homePage = new HomePage().open();
        SideModalMenu menu = homePage.getHeader().openSideModalMenu();
        Assert.assertTrue(homePage
                        .getHeader()
                        .isSideModalMenuVisible(),
                "Side Menu have to be visible but is invisible");
        menu.closeSideModalMenu();
        Assert.assertFalse(homePage
                        .getHeader()
                        .isSideModalMenuVisible(),
                "Side Menu have to be invisible but is visible");
    }
}
