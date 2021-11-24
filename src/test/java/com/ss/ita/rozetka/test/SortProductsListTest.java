package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.ProductTypePage;
import com.ss.ita.rozetka.pageobject.product.GeneralProductCategory;
import com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.pageobject.utils.ProductsListSortType;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import org.testng.annotations.Test;

public class SortProductsListTest extends TestRunner {

    @Test
    public void verifyActionSorting(){
        ProductTypePage productTypePage = new HomePage()
                .open()
                .openProductCategoryPage(GeneralProductCategory.SMARTPHONE_TV_ELECTRONICS)
                .openProductTypePage(ProductCategoryAndSubCategory.MOBILE_PHONES_CATEGORY)
                .sortProductsListBy(ProductsListSortType.ACTION);
    }
}
