package com.ss.ita.rozetka;

import com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory;
import com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.ui.elements.Header;
import com.ss.ita.rozetka.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComparisonTest {
    @Test
    public void verifyAddingToComparison() {
        Header header = new HomePage().open().openProductCategoryPage(GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(ProductCategoryAndSubCategory.NOTEBOOKS)
                .openProductPage(1)
                .addProductToComparison();

        Assert.assertEquals(header.getProductsForComparisonCount(),1);
    }
}