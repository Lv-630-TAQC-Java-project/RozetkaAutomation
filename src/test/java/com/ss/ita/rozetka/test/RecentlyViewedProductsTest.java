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

        String firstOpenedProductName = productPage
                .openProductPage(1)
                .getName();

        Header header = productPage.getHeader();

        String recentlyViewedProductName = header
                .openHomePage()
                .getRecentlyViewedProductName(1);
        assertThat(recentlyViewedProductName)
                .as("First product name in Recently Opened products should be equal to last viewed product name")
                .isEqualTo(firstOpenedProductName);

        String secondOpenedProductName = header
                .openHomePage()
                .openProductCategoryPage(COTTAGE_GARDEN_BACKYARD)
                .openProductTypePage(GARDEN_TECH_CATEGORY)
                .openProductPage(1)
                .getName();

        String thirdOpenedProductName = header
                .openHomePage()
                .openProductCategoryPage(NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(NOTEBOOKS_CATEGORY)
                .openProductPage(1)
                .getName();

        List<String> recentlyViewedProductNames = header
                .openHomePage()
                .getRecentlyViewedProductNames();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(recentlyViewedProductNames.get(0))
                .as("First product name in Recently Opened products should be equal to last viewed product name")
                .isEqualTo(thirdOpenedProductName);
        softly.assertThat(recentlyViewedProductNames.get(1))
                .as("Second product name in Recently Opened products should be equal to second viewed product name")
                .isEqualTo(secondOpenedProductName);
        softly.assertThat(recentlyViewedProductNames.get(2))
                .as("Third product name in Recently Opened products should be equal to first viewed product name")
                .isEqualTo(firstOpenedProductName);
        softly.assertAll();
    }

    @Test
    @Description(value = "Verifies that opening same product multiple times does not add new entries in recently viewed product list")
    @TmsLink(value = "LVTAQC630-44")
    public void verifyProductAddedOnlyOnce() {
        var homePage = new HomePage().open();
        ProductTypePage productPage = homePage
                .openProductCategoryPage(HOUSEHOLD_APPLIANCES)
                .openProductTypePage(KITCHEN_APPLIANCES_CATEGORY);
        boolean isProductTypePageOpened = productPage.isOpened();
        assertThat(getCurrentUrl())
                .as("Kitchen appliances category page should be opened")
                .isEqualTo("https://bt.rozetka.com.ua/tehnika-dlya-kuhni/c435974/");
        assertThat(isProductTypePageOpened)
                .as("Product type page should be opened")
                .isTrue();
        var firstOpenedProduct = productPage
                .openProductPage(1)
                .getName();

        var header = productPage.getHeader();

        var recentlyOpenedProductName = header
                .openHomePage()
                .getRecentlyViewedProductName(1);
        assertThat(recentlyOpenedProductName)
                .as("First product name in Recently Opened products should be equal to last viewed product name")
                .isEqualTo(firstOpenedProduct);

        var secondOpenedProduct = homePage
                .openProductCategoryPage(HOUSEHOLD_APPLIANCES)
                .openProductTypePage(KITCHEN_APPLIANCES_CATEGORY)
                .getProduct(1)
                .getTitle();
        var recentlyViewedProductNames = header
                .openHomePage()
                .getRecentlyViewedProductNames();
        assertThat(recentlyViewedProductNames.size())
                .as("Recently viewed product list should contain one product")
                .isEqualTo(1);
        assertThat(recentlyViewedProductNames.get(0))
                .as("Product in recently viewed product list should be the same as last opened product")
                .isEqualTo(secondOpenedProduct);
    }
}
