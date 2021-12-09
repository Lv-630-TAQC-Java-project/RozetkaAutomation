package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.elements.Header;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.ProductTypePage;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.List;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.HOUSEHOLD_APPLIANCES;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.KITCHEN_APPLIANCES_CATEGORY;
import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.COTTAGE_GARDEN_BACKYARD;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.GARDEN_TECH_CATEGORY;
import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.NOTEBOOKS_CATEGORY;
import static com.ss.ita.rozetka.pageobject.utils.PageUtil.getCurrentUrl;
import static org.assertj.core.api.Assertions.assertThat;

public class RecentlyViewedProductsTest extends TestRunner {

    @Test
    @Description(value = "Verifies that products opened by user are displayed on home page under recently viewed products list in order from last opened to first opened")
    @TmsLink(value = "LVTAQC630-30")
    public void verifyLastViewedProductAddedToTheList() {
        ProductTypePage productPage = new HomePage()
                .open()
                .openProductCategoryPage(HOUSEHOLD_APPLIANCES)
                .openProductTypePage(KITCHEN_APPLIANCES_CATEGORY);
        boolean isProductTypePageOpened = productPage.isOpened();
        assertThat(getCurrentUrl())
                .as("Kitchen appliances category page should be opened")
                .isEqualTo("https://bt.rozetka.com.ua/tehnika-dlya-kuhni/c435974/");
        assertThat(isProductTypePageOpened)
                .as("Product type page should be opened")
                .isTrue();

        String firstOpenedProductTitle = productPage
                .openProductPage(1)
                .getTitle();

        Header header = productPage.getHeader();

        String recentlyViewedProductTitle = header
                .openHomePage()
                .getRecentlyViewedProductTitle(1);
        assertThat(recentlyViewedProductTitle)
                .as("First product name in Recently Opened products should be equal to last viewed product name")
                .isEqualTo(firstOpenedProductTitle);

        String secondOpenedProductTitle = header
                .openHomePage()
                .openProductCategoryPage(COTTAGE_GARDEN_BACKYARD)
                .openProductTypePage(GARDEN_TECH_CATEGORY)
                .openProductPage(1)
                .getTitle();

        String thirdOpenedProductTitle = header
                .openHomePage()
                .openProductCategoryPage(NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(NOTEBOOKS_CATEGORY)
                .openProductPage(1)
                .getTitle();

        List<String> recentlyViewedProductTitles = header
                .openHomePage()
                .getRecentlyViewedProductTitle();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(recentlyViewedProductTitles.get(0))
                .as("First product name in Recently Opened products should be equal to last viewed product name")
                .isEqualTo(thirdOpenedProductTitle);
        softly.assertThat(recentlyViewedProductTitles.get(1))
                .as("Second product name in Recently Opened products should be equal to second viewed product name")
                .isEqualTo(secondOpenedProductTitle);
        softly.assertThat(recentlyViewedProductTitles.get(2))
                .as("Third product name in Recently Opened products should be equal to first viewed product name")
                .isEqualTo(firstOpenedProductTitle);
        softly.assertAll();
    }

    @Test
    @Description(value = "Verifies that opening same product multiple times does not add new entries in recently viewed product list")
    @TmsLink(value = "LVTAQC630-44")
    public void verifyProductAddedOnlyOnce() {
        var homePage = new HomePage().open();
        var productPage = homePage
                .openProductCategoryPage(HOUSEHOLD_APPLIANCES)
                .openProductTypePage(KITCHEN_APPLIANCES_CATEGORY);
        var isProductTypePageOpened = productPage.isOpened();
        assertThat(getCurrentUrl())
                .as("Kitchen appliances category page should be opened")
                .isEqualTo("https://bt.rozetka.com.ua/tehnika-dlya-kuhni/c435974/");
        assertThat(isProductTypePageOpened)
                .as("Product type page should be opened")
                .isTrue();
        var firstOpenedProductTitle = productPage
                .openProductPage(1)
                .getTitle();

        var header = productPage.getHeader();

        var recentlyOpenedProductTitle = header
                .openHomePage()
                .getRecentlyViewedProductTitle(1);
        assertThat(recentlyOpenedProductTitle)
                .as("First product name in Recently Opened products should be equal to last viewed product name")
                .isEqualTo(firstOpenedProductTitle);

        var secondOpenedProductTitle = homePage
                .openProductCategoryPage(HOUSEHOLD_APPLIANCES)
                .openProductTypePage(KITCHEN_APPLIANCES_CATEGORY)
                .openProductPage(1)
                .getTitle();
        var recentlyViewedProductTitle = header
                .openHomePage()
                .getRecentlyViewedProductTitle();
        assertThat(recentlyViewedProductTitle)
                .as("Recently viewed product list should contain one product")
                .hasSize(1);
        assertThat(recentlyViewedProductTitle)
                .as("Product in recently viewed product list should be the same as last opened product")
                .contains(secondOpenedProductTitle);
    }
}
