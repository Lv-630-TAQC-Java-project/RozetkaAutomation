package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.Modals.SideModalMenu;
import com.ss.ita.rozetka.ui.TestUtils.TestRunner;
import com.ss.ita.rozetka.ui.elements.Header;
import com.ss.ita.rozetka.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SideModalMenuTest extends TestRunner {

    @Test
    public void verifyOpenCloseSideModalMenu() {
        HomePage homePage = new HomePage().open();
        Header header = homePage.getHeader();
        SideModalMenu menu = header.openSideModalMenu();
        Assert.assertTrue(header.isSideModalMenuVisible(), "Side Menu should be visible");
        menu.closeSideModalMenu();
        Assert.assertFalse(header.isSideModalMenuVisible(), "Side Menu should be invisible");
    }
}
