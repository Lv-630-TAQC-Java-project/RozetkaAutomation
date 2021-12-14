package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.CredentialProperties;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.product.GeneralProductCategory;
import com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecentlyViewedTest extends TestRunner {
    @Test
    public void verifyOpenedProductWillBeInRecentlyViewedPage() {
        var header = new HomePage()
                .open()
                .getHeader();

        var credentialProperties = new CredentialProperties();

        var homePage = header
                .openLoginModal()
                .loginWithFacebook(credentialProperties.getFacebookEmail(), credentialProperties.getFacebookPassword());

        var productPage = homePage
                .openProductCategoryPage(GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(ProductCategoryAndSubCategory.NOTEBOOKS_CATEGORY)
                .openProductPage(1);

        var productTitleOnProductPage = productPage.getTitle();

        var recentlyViewedPage = header
                .openSideMenuModal()
                .openPersonalInformationPage()
                .getOwnCabinetSideMenu()
                .openRecentlyViewedProductsPage();

        var productTitleOnRecentlyViewedPage = recentlyViewedPage.getProductTitle(1);

        assertThat(productTitleOnProductPage)
                .as("Title should be the same")
                .isEqualTo(productTitleOnRecentlyViewedPage);

        recentlyViewedPage.clearRecentlyViewedProductsList();

        assertThat(recentlyViewedPage.isProductListEmpty())
                .as("Product list should be empty")
                .isTrue();
    }
}
