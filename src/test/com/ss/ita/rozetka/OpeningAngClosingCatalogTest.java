package com.ss.ita.rozetka;

import com.ss.ita.rozetka.ui.elements.Header;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.runner.TestRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class OpeningAngClosingCatalogTest extends TestRunner {

    @Test
    public void verifyThatCatalogOpensAndCloses(){
        Header catalog = new HomePage().open().getHeader().openCatalogModal().getHeader();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(catalog.isCatalogModalDisplayed());

        catalog.closeCatalogModal();
        softAssert.assertFalse(catalog.isCatalogModalDisplayed());
        softAssert.assertAll();
    }
}
