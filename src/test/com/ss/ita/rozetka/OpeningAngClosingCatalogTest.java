package com.ss.ita.rozetka;

import com.ss.ita.rozetka.ui.Modals.CatalogModal;
import com.ss.ita.rozetka.ui.TestUtils.TestRunner;
import com.ss.ita.rozetka.ui.elements.Header;
import com.ss.ita.rozetka.ui.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class OpeningAngClosingCatalogTest extends TestRunner {

    @Test
    public void verifyThatCatalogOpensAndCloses(){
        Header header = new HomePage()
                .open()
                .getHeader();

        header.openCatalogModal();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(header.isCatalogModalVisible());

        header.closeCatalogModal();
        softAssert.assertFalse(header.isCatalogModalVisible());
        softAssert.assertAll();
    }
}
