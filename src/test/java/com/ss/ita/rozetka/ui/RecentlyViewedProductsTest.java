package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.pages.ProductTypePage;
import com.ss.ita.rozetka.ui.TestUtils.TestRunner;
import com.ss.ita.rozetka.ui.pages.HomePage;

import io.qameta.allure.Issue;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory.HOUSEHOLD_APPLIANCES;
import static com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory.KITCHEN_APPLIANCES_CATEGORY;
import static com.ss.ita.rozetka.ui.util.PageUtil.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RecentlyViewedProductsTest extends TestRunner {

    @Test
    @Issue("LVTAQC630-8")
    public void verifyLastViewedProductAddedToTheList() {
        ProductTypePage productPage = new HomePage()
                .open()
                .openProductCategoryPage(HOUSEHOLD_APPLIANCES)
                .openProductTypePage(KITCHEN_APPLIANCES_CATEGORY);
        boolean isProductTypePageOpened = productPage.isProductTypePageHeadingVisible();
        assertThat(getCurrentUrl())
                .as("Kitchen appliances category page should be opened")
                .isEqualTo("https://bt.rozetka.com.ua/tehnika-dlya-kuhni/c435974/");
        assertThat(isProductTypePageOpened)
                .as("Product type page should be opened")
                .isTrue();
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