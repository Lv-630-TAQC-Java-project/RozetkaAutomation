package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.Modals.HamburgerModal;
import com.ss.ita.rozetka.ui.elements.Header;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.runner.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HamburgerModalTest extends TestRunner {

    @Test
    public void verifyOpenHamburgerModalIs(){
        HomePage homePage = new HomePage().open();
        HamburgerModal menu = homePage.header.openHamburgerModal();
        Header header = homePage.header;
        boolean actualIsMenuOpen = header.isVisibleHamburgerModal();
        Assert.assertTrue(actualIsMenuOpen);
    }

    @Test
    public void verifyCloseHamburgerModal(){
        HomePage homePage = new HomePage().open();
        HamburgerModal menu = homePage.header.openHamburgerModal();
        Header header = homePage.header;
        menu.closeHamburgerModal();
        boolean actualIsMenuOpen = header.isVisibleHamburgerModal();
        Assert.assertFalse(actualIsMenuOpen);
     }
 }
