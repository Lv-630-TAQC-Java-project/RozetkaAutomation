package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.pages.ProductCategoryPage;
import com.ss.ita.rozetka.ui.TestUtils.TestRunner;

import io.qameta.allure.Issue;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory.HOUSEHOLD_APPLIANCES;
import static com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory.KITCHEN_APPLIANCES_CATEGORY;
import static com.ss.ita.rozetka.ui.util.PageUtil.getCurrentUrl;
import static org.assertj.core.api.Assertions.assertThat;

public class NavigationTest extends TestRunner {

    @Test
    @Issue("LVTAQC630-7")
    public void verifyReturnToHomePage() {
        ProductCategoryPage page = new HomePage()
                .open()
                .openProductCategoryPage(HOUSEHOLD_APPLIANCES);
        boolean isProductPageOpened = page.isProductCategoryPageHeadingVisible();
        assertThat(getCurrentUrl())
                .as("Products for house category page should be opened")
                .isEqualTo("https://bt.rozetka.com.ua/");
        assertThat(isProductPageOpened)
                .as("Product category page should be opened")
                .isTrue();
        boolean isProductTypePageOpened = page
                .openProductTypePage(KITCHEN_APPLIANCES_CATEGORY)
                .isProductTypePageHeadingVisible();
        assertThat(getCurrentUrl())
                .as("Kitchen appliances category page should be opened")
                .isEqualTo("https://bt.rozetka.com.ua/tehnika-dlya-kuhni/c435974/");
        assertThat(isProductTypePageOpened)
                .as("Product type page should be opened")
                .isTrue();
        boolean isHomePageOpened = page
                .getHeader()
                .openHomePage()
                .isSliderVisible();
        assertThat(getCurrentUrl())
                .as("Home page should be opened")
                .isEqualTo("https://rozetka.com.ua/");
        assertThat(isHomePageOpened)
                .as("Home page should be opened")
                .isTrue();
    }
}
