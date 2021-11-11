package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.pages.ProductPage;
import com.ss.ita.rozetka.ui.runner.TestRunner;
import com.ss.ita.rozetka.ui.pages.HomePage;

import org.testng.annotations.Test;

import static com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory.PRODUCTS_FOR_HOUSE;
import static com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory.KITCHEN_APPLIANCES_CATEGORY;

public class RecentlyViewedProductsTest extends TestRunner {

    @Test
    public void verifyLastViewedProductAddedToTheList() {
        ProductPage productPage = new HomePage().open().openProductCategoryPage(PRODUCTS_FOR_HOUSE).openProductTypePage(KITCHEN_APPLIANCES_CATEGORY).openProductPage(1);
        String productName = productPage.getProductTitle();
        String productNameIn = productPage.getProductTitle();
    }
}
