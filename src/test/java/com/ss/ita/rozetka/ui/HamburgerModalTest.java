package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.Modals.HamburgerModal;
import com.ss.ita.rozetka.ui.elements.Header;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.runner.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HamburgerModalTest extends TestRunner {

    @Test
    public void verifyOpenHamburgerModal(){
        HomePage homePage = new HomePage().open();
        homePage.header.openHamburgerModal();
        Assert.assertTrue(homePage.header.isVisibleHamburgerModal());
    }

    @Test
    public void verifyCloseHamburgerModal(){
        HomePage homePage = new HomePage().open();
        HamburgerModal menu =homePage.header.openHamburgerModal();
        menu.closeHamburgerModal();
        Assert.assertFalse(homePage.header.isVisibleHamburgerModal());
     }
 }
