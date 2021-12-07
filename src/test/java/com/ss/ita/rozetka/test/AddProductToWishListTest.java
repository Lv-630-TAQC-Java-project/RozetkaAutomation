package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.product.GeneralProductCategory;
import com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class AddProductToWishListTest extends TestRunner {

    @Test
    @Description("Verify user can add product to wish list")
    @TmsLink(value = "LVTAQC630-57")
    public void verifyUserCanAddProductToWishList() throws InterruptedException {
        var header = new HomePage()
                .open()
                .getHeader();

        var homePage = header
                .openLoginModal()
                .loginWithFacebook();

        var productTypePage = homePage
                .openProductCategoryPage(GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(ProductCategoryAndSubCategory.NOTEBOOKS_CATEGORY);

        var productTitle = productTypePage.getProductTitle(1);

        productTypePage
                .openProductPage(1)
                .addProductToFavourite();

        var userPage = header.openSideMenuModal().openWishList();

        var productTitleInWishList = userPage.getProductTitle(1);

        assertThat(productTitle)
                .as("Product title should be the same")
                .isEqualTo(productTitleInWishList);

        var sumOfProducts = userPage.countProductsListSize();

        userPage
                .selectProductInWishList(1)
                .removeProductFromWishList();

        assertThat(sumOfProducts)
                .as("Product title should not be the same")
                .isNotEqualTo(userPage.countProductsListSize());
    }
}
