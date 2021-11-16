package com.ss.ita.rozetka;

import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.pages.ProductTypePage;
import org.testng.annotations.Test;
import com.ss.ita.rozetka.ui.TestUtils.TestRunner;

import static com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS;
import static com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory.NOTEBOOKS;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductsInCategoryArePresentedTest extends TestRunner {

    @Test
    public void verifyThatProductsArePresentedInNotebookCategory() {
        ProductTypePage productTypePage = new HomePage()
                .open()
                .openProductCategoryPage(NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(NOTEBOOKS);

        assertThat(productTypePage
                .getProductsCount())
                .as("There should be presented at least 10 products")
                .isGreaterThan(10);
    }
}
