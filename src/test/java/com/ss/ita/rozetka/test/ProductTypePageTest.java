package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.ProductTypePage;
import com.ss.ita.rozetka.pageobject.product.GeneralProductCategory;
import com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.*;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductTypePageTest extends TestRunner {

    private ProductTypePage openSelectedCategory
            (GeneralProductCategory generalProductCategory, ProductCategoryAndSubCategory productCategoryAndSubCategory) {
        ProductTypePage productTypePage = new HomePage()
                .open()
                .openProductCategoryPage(generalProductCategory)
                .openProductTypePage(productCategoryAndSubCategory);
        return productTypePage;
    }

    @Test
    public void verifyThatProductsArePresentedInNotebookCategory() {
        assertThat(openSelectedCategory(NOTEBOOKS_AND_COMPUTERS, NOTEBOOKS_CATEGORY).getProductsCount())
                .as("There should be presented at least 10 products")
                .isGreaterThan(10);
    }

    @Test
    public void verifyThatProductsArePresentedInTVAccessoriesCategory() {
        assertThat(openSelectedCategory(PHONES_AND_TV, TV_ACCESSORIES_CATEGORY).getProductsCount())
                .as("There should be presented at least 10 products")
                .isGreaterThan(10);
    }
}
