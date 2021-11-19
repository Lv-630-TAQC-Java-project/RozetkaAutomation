package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.ProductTypePage;
import org.testng.annotations.Test;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.NOTEBOOKS;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductTypePageTest extends TestRunner {

    @Test
    public void verifyThatProductsArePresentedInNotebookCategory() {
        ProductTypePage productTypePage = new HomePage()
                .open()
                .openProductCategoryPage(NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(NOTEBOOKS);

        assertThat(productTypePage.getProductsCount())
                .as("There should be presented at least 10 products")
                .isGreaterThan(10);
    }
}
