package com.ss.ita.rozetka;

import com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory;
import com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.ui.elements.Header;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComparisonTest {
    @Test
    public void verifyAddingToComparison() {
        Header header = new HomePage().open().openProductCategoryPage(GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(ProductCategoryAndSubCategory.NOTEBOOK_CATEGORY)
                .openProductPage(1)
                .addProductToComparison();

        Assert.assertEquals(header.getCountOfComparisonProducts(),1);
    }
}