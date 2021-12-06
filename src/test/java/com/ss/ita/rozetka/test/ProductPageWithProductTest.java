package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.elements.Product;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.ProductPage;
import com.ss.ita.rozetka.pageobject.pages.ProductTypePage;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.NOTEBOOKS_CATEGORY;

public class ProductPageWithProductTest extends TestRunner {

    @Test
    @Description("Verify that information about product presented on Product type page and Product page is similar")
    @TmsLink(value = "LVTAQC630-39")
    public void verifyThatProductInformationIsSimilar() {
        ProductTypePage productTypePage = new HomePage()
                .open()
                .openProductCategoryPage(NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(NOTEBOOKS_CATEGORY);

        int productNumber = 1;
        Product product = productTypePage.getProduct(productNumber);

        String productTitleOnProductTypePage = product.getTitle();
        int productPriceOnProductTypePage = product.getPrice();
        String productDescriptionOnProductTypePage = product.getDescription();

        ProductPage productPage = productTypePage.openProductPage(productNumber);

        String productTitleOnProductPage = productPage.getName();
        int productPriceOnProductPage = productPage.getPrice();
        String productDescriptionOnProductPage = productPage.getDescription();

        SoftAssertions softAssertion = new SoftAssertions();
        softAssertion
                .assertThat(productTitleOnProductTypePage)
                .as("There should be similar titles")
                .isEqualTo(productTitleOnProductPage);
        softAssertion
                .assertThat(productPriceOnProductTypePage)
                .as("There should be similar price")
                .isEqualTo(productPriceOnProductPage);
        softAssertion
                .assertThat(productDescriptionOnProductTypePage)
                .as("There should be similar description")
                .isEqualTo(productDescriptionOnProductPage);
        softAssertion.assertAll();
    }
}
