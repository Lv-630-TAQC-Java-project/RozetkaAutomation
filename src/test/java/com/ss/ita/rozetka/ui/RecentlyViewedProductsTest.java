package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.pages.ProductPage;
import com.ss.ita.rozetka.ui.pages.ProductTypePage;
import com.ss.ita.rozetka.ui.runner.TestRunner;
import com.ss.ita.rozetka.ui.pages.HomePage;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory.PRODUCTS_FOR_HOUSE;
import static com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory.KITCHEN_APPLIANCES_CATEGORY;

public class RecentlyViewedProductsTest extends TestRunner {

    @Test
    public void verifyLastViewedProductAddedToTheList() {
        ProductTypePage productPage = new HomePage().open()
                .openProductCategoryPage(PRODUCTS_FOR_HOUSE)
                .openProductTypePage(KITCHEN_APPLIANCES_CATEGORY);
        String productTypePageUrl = productPage.getHeader().getCurrentUrl();
        Assert.assertEquals(productTypePageUrl, "https://bt.rozetka.com.ua/tehnika-dlya-kuhni/c435974/");
        String productName = productPage.openProductPage(1).getProductTitle();
        String recentlyViewedProductName = productPage
                .getHeader()
                .openHomePage()
                .getRecentlyViewedProductName(1);
        Assert.assertEquals(recentlyViewedProductName, productName);
    }
}
