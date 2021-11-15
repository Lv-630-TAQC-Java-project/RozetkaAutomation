package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.Modals.SideMenuModal;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.runner.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SideMenuModalTest extends TestRunner {

    @Test
    public void verifyOpenHamburgerModal() {
        HomePage homePage = new HomePage().open();
        homePage.header.openHamburgerModal();
        Assert.assertTrue(homePage.header.isVisibleSideMenuModal());
    }

    @Test
    public void verifyCloseHamburgerModal() {
        HomePage homePage = new HomePage().open();
        SideMenuModal menu = homePage.header.openHamburgerModal();
        menu.closeSideMenuModal();
        Assert.assertFalse(homePage.header.isVisibleSideMenuModal());
    }
 }
