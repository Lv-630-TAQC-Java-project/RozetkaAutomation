package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.ProductTypePage;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.*;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductTypePageTest extends TestRunner {

    @Test
    public void verifyThatProductsArePresentedInNotebookCategory() {
        ProductTypePage productTypePage = new HomePage()
                .open()
                .openGeneralProductCategory(NOTEBOOKS_AND_COMPUTERS)
                .openProductCategoryAndSubCategory(NOTEBOOKS_CATEGORY);

        assertThat(productTypePage.getProductsCount())
                .as("There should be presented at least 10 products")
                .isGreaterThan(10);
    }

    @Test
    public void verifyThatProductsArePresentedInTVAccessoriesCategory() {
        ProductTypePage productTypePage = new HomePage()
                .open()
                .openGeneralProductCategory(PHONES_AND_TV)
                .openProductCategoryAndSubCategory(TV_ACCESSORIES_CATEGORY);

        assertThat(productTypePage.getProductsCount())
                .as("There should be presented at least 10 products")
                .isGreaterThan(10);
    }
}
