package com.ss.ita.rozetka;

import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.pages.ProductTypePage;
import com.ss.ita.rozetka.ui.runner.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS;
import static com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory.NOTEBOOKS;

public class ProductsInCategoryArePresentedTest extends TestRunner {

    @Test
    public void verifyThatProductsArePresentedInNotebookCategory() {
        ProductTypePage productTypePage = new HomePage().open()
                .openProductCategoryPage(NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(NOTEBOOKS);
        Assert.assertTrue(productTypePage.getProductsCount() > 10);
    }
}
