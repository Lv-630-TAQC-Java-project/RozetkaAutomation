package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.Modals.SideModalMenu;
import com.ss.ita.rozetka.ui.elements.Header;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.runner.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SideModalMenuTest extends TestRunner {

    @Test
    public void verifyOpenCloseSideModalMenu() {
        HomePage homePage = new HomePage().open();
        Header header = homePage.getHeader();
        SideModalMenu menu = header.openSideModalMenu();
        Assert.assertTrue(header.isSideModalMenuVisible(), "Side Menu have to be visible but is invisible");
        menu.closeSideModalMenu();
        Assert.assertFalse(header.isSideModalMenuVisible(), "Side Menu have to be invisible but is visible");
    }
}
