package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.pages.ProductTypePage;
import com.ss.ita.rozetka.ui.TestUtils.TestRunner;
import com.ss.ita.rozetka.ui.pages.HomePage;

import org.testng.annotations.Test;

import static com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory.PRODUCTS_FOR_HOUSE;
import static com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory.KITCHEN_APPLIANCES_CATEGORY;
import static com.ss.ita.rozetka.ui.util.PageUtil.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RecentlyViewedProductsTest extends TestRunner {

    @Test
    public void verifyLastViewedProductAddedToTheList() {
        ProductTypePage productPage = new HomePage().open()
                .openProductCategoryPage(PRODUCTS_FOR_HOUSE)
                .openProductTypePage(KITCHEN_APPLIANCES_CATEGORY);
        assertThat(getCurrentUrl())
                .as("Kitchen appliances category page should be opened")
                .isEqualTo("https://bt.rozetka.com.ua/tehnika-dlya-kuhni/c435974/");
        String productName = productPage
                .openProductPage(1)
                .getName();
        String recentlyViewedProductName = productPage
                .getHeader()
                .openHomePage()
                .getRecentlyViewedProductName(1);
        assertThat(recentlyViewedProductName)
                .as("First product name in Recently Opened products should be equal to last viewed product name")
                .isEqualTo(productName);
    }
}
