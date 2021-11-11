package com.ss.ita.rozetka;

import com.ss.ita.rozetka.ui.Modals.CatalogModal;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.runner.TestRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OpeningAngClosingCatalogTest extends TestRunner {

    @Test
    public void verifyThatCatalogOpensAndCloses(){
        CatalogModal catalogModal = new HomePage().open().openCatalogModal();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(catalogModal.isCatalogModalDisplayed());

        catalogModal.openCatalogModal();
        softAssert.assertFalse(catalogModal.isCatalogModalDisplayed());
        softAssert.assertAll();

    }
}
