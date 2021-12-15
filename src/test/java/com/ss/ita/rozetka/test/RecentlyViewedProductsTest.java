package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.utils.Language;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

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
        var productPage = new HomePage()
                .open()
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

        var recentlyViewedProductTitle = header
                .openHomePage()
                .getRecentlyViewedProductTitle(1);
        assertThat(recentlyViewedProductTitle)
                .as("First product name in Recently Opened products should be equal to last viewed product name")
                .isEqualTo(firstOpenedProductTitle);

        var secondOpenedProductTitle = header
                .openHomePage()
                .openProductCategoryPage(COTTAGE_GARDEN_BACKYARD)
                .openProductTypePage(GARDEN_TECH_CATEGORY)
                .openProductPage(1)
                .getTitle();

        var thirdOpenedProductTitle = header
                .openHomePage()
                .openProductCategoryPage(NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(NOTEBOOKS_CATEGORY)
                .openProductPage(1)
                .getTitle();

        var recentlyViewedProductTitles = header
                .openHomePage()
                .getRecentlyViewedProductTitles();

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
                .getRecentlyViewedProductTitles();
        assertThat(recentlyViewedProductTitle)
                .as("Recently viewed product list should contain one product")
                .hasSize(1);
        assertThat(recentlyViewedProductTitle)
                .as("Product in recently viewed product list should be the same as last opened product")
                .contains(secondOpenedProductTitle);
    }

    @Test
    @Description(value = "Verifies that 'Show more' button appears in recently viewed products after opening more than 6 producs and clicking it will display other products")
    @TmsLink(value = "LVTAQC630-68")
    public void verifyClickingShowMoreDisplaysProducts() {
        var homePage = new HomePage().open();

        var header = homePage.getHeader();
        header.changeLanguage(Language.UA);

        var productPage = homePage
                .openProductCategoryPage(HOUSEHOLD_APPLIANCES)
                .openProductTypePage(KITCHEN_APPLIANCES_CATEGORY);
        var isProductTypePageOpened = productPage.isOpened();
        assertThat(getCurrentUrl())
                .as("Kitchen appliances category page should be opened")
                .isEqualTo("https://bt.rozetka.com.ua/ua/tehnika-dlya-kuhni/c435974/");
        assertThat(isProductTypePageOpened)
                .as("Product type page should be opened")
                .isTrue();

        var numberOfProducts = 7;

        for (int i = 1; i <= numberOfProducts; i++) {
            productPage.openProductPage(i);
            productPage.back();
        }

        header.openHomePage();
        var recentlyOpenedProductsTitles = homePage.getRecentlyViewedProductTitles();
        assertThat(recentlyOpenedProductsTitles)
                .as("Only 6 or less products should be displayed")
                .hasSizeLessThan(7);

        homePage.expandRecentlyViewedProductsList();

        var expandedRecentlyOpenedProductsTitles = homePage.getRecentlyViewedProductTitles();

        assertThat(expandedRecentlyOpenedProductsTitles)
                .as("All 7 opened products should be displayed")
                .hasSize(numberOfProducts);
    }
}
