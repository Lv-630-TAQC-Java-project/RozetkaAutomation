package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.ProductTypePage;
import com.ss.ita.rozetka.pageobject.utils.ProductsListSortType;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.STATIONERY_AND_BOOKS;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.BOOKS_CATEGORY;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductSortTypePageTest extends TestRunner {
    @Test
    public void verifyThatProductsArePresentedInBooksCategory(){
        ProductTypePage productTypePage = new HomePage()
                .open()
                .openProductCategoryPage(STATIONERY_AND_BOOKS)
                .openProductTypePage(BOOKS_CATEGORY)
                .sortProductsListBy(ProductsListSortType.ACTION);

        String labelClassAction = "goods-tile__label promo-label promo-label_type_action ng-star-inserted";

        assertThat(productTypePage.getLabelProductStatus())
                .as("Product must have tile label 'action'")
                .isEqualTo(labelClassAction);
    }
}
