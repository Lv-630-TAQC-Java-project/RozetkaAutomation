package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.ProductTypePage;
import com.ss.ita.rozetka.pageobject.product.GeneralProductCategory;
import com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.*;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductTypePageTest extends TestRunner {

    @DataProvider(name = "DPCategoriesWithOneSubCategory")
    public Object[][] dpCategoriesWithThreeSubCategories() {
        return new Object[][]{
                {NOTEBOOKS_AND_COMPUTERS, NOTEBOOKS_CATEGORY},
                {PHONES_AND_TV_CATEGORY, TV_ACCESSORIES_CATEGORY},
                {PLUMBING_AND_REPAIR_CATEGORY, SPA_POOLS_CATEGORY}
        };
    }

    @Test(dataProvider = "DPCategoriesWithOneSubCategory")
    public void verifyThatProductsArePresentedInCategoriesWithOneSubCategory
            (GeneralProductCategory generalProductCategory, ProductCategoryAndSubCategory productCategoryAndSubCategory) {
        ProductTypePage productTypePage = new HomePage()
                .open()
                .openProductCategoryPage(generalProductCategory)
                .openProductTypePage(productCategoryAndSubCategory);

        assertThat(productTypePage.getProductsCount())
                .as("There should be presented at least 10 products")
                .isGreaterThan(10);
    }
}
