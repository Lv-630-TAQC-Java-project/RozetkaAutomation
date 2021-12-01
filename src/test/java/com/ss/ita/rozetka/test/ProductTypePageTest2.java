package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.ProductTypePage;
import com.ss.ita.rozetka.pageobject.utils.ProductsListSortType;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.STATIONERY_AND_BOOKS;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.BOOKS_CATEGORY;

public class ProductTypePageTest2 extends TestRunner {
    @Test
    public void verifyThatProductsArePresentedInBooksCategory(){
        ProductTypePage productTypePage = new HomePage()
                .open()
                .openProductCategoryPage(STATIONERY_AND_BOOKS)
                .openProductTypePage(BOOKS_CATEGORY)
                .sortProductsListBy(ProductsListSortType.ACTION);
    }
}
