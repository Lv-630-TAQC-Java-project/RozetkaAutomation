package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.pages.*;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.HOUSEHOLD_APPLIANCES;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.KITCHEN_APPLIANCES_CATEGORY;
import static com.ss.ita.rozetka.pageobject.utils.PageUtil.getCurrentUrl;
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
