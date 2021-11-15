package com.ss.ita.rozetka;

import com.ss.ita.rozetka.ui.Modals.CatalogModal;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.runner.TestRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.ss.ita.rozetka.ui.elements.Header.isCatalogModalDisplayed;

public class OpeningAngClosingCatalogTest extends TestRunner {

    @Test
    public void verifyThatCatalogOpensAndCloses(){
        CatalogModal catalogModal = new HomePage().open().getHeader().openCatalogModal();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isCatalogModalDisplayed());

        catalogModal.getHeader().closeCatalogModal();
        softAssert.assertFalse(isCatalogModalDisplayed());
        softAssert.assertAll();
    }
}
