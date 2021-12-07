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
    public void verifyUserCanAddProductToWishList() {
        var homepage = new HomePage()
                .open()
                .getHeader()
                .openLoginModal()
                .loginWithFacebook();

        var productTypePage = homepage
                .openProductCategoryPage(GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(ProductCategoryAndSubCategory.NOTEBOOKS_CATEGORY);

        var productTitle = productTypePage.getProductTitle(1);

        var userPage = productTypePage
                .openProductPage(1)
                .addProductToFavourite()
                .getHeader()
                .openWishList();

        var productTitleInWishList = userPage.getProductTitle(1);

        assertThat(productTitle)
                .as("Product title should be the same")
                .isEqualTo(productTitleInWishList);

        userPage
                .selectProductInWishList(1)
                .removeProductFromWishList();

        var productTitleAfterRemoving = userPage.getProductTitle(1);

        assertThat(productTitleInWishList)
                .as("Product title should not be the same")
                .isNotEqualTo(productTitleAfterRemoving);
    }
}
