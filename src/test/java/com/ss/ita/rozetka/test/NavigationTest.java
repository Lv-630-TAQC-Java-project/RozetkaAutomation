package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.ProductCategoryPage;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;

import io.qameta.allure.Issue;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.HOUSEHOLD_APPLIANCES;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.KITCHEN_APPLIANCES_CATEGORY;
import static com.ss.ita.rozetka.pageobject.utils.PageUtil.getCurrentUrl;
import static org.assertj.core.api.Assertions.assertThat;

public class NavigationTest extends TestRunner {

    @Test
    @Issue("LVTAQC630-7")
    public void verifyReturnToHomePage() {
        ProductCategoryPage page = new HomePage()
                .open()
                .openProductCategoryPage(HOUSEHOLD_APPLIANCES);

        boolean isProductPageOpened = page.isOpened();
        assertThat(isProductPageOpened)
                .as("Product category page should be opened")
                .isTrue();

        boolean isProductTypePageOpened = page
                .openProductTypePage(KITCHEN_APPLIANCES_CATEGORY)
                .isOpened();
        assertThat(isProductTypePageOpened)
                .as("Product type page should be opened")
                .isTrue();

        boolean isHomePageOpened = page
                .getHeader()
                .openHomePage()
                .isOpened();
        assertThat(getCurrentUrl())
                .as("Home page should be opened")
                .isEqualTo("https://rozetka.com.ua/");
        assertThat(isHomePageOpened)
                .as("Home page should be opened")
                .isTrue();
    }
}
