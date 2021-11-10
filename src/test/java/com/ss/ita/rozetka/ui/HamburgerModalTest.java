package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.Modals.HamburgerModal;
import com.ss.ita.rozetka.ui.pages.Header;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.runner.TestRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HamburgerModalTest extends TestRunner {

    @Test
    public void verifyOpenHamburgerModal(){
        HamburgerModal menu = new HomePage().open().openHamburgerModal();
        Header header = new Header();
        boolean actualIsMenuOpen = header.isVisibleHamburgerModal();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualIsMenuOpen);
        menu.closeHamburgerModal();
        actualIsMenuOpen = header.isVisibleHamburgerModal();
        softAssert.assertFalse(actualIsMenuOpen);
        softAssert.assertAll();
    }
}
