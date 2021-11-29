package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.elements.Product;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.ProductPage;
import com.ss.ita.rozetka.pageobject.pages.ProductTypePage;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.NOTEBOOKS_CATEGORY;

public class CompareTest extends TestRunner {
    @Test
    public void verifyThatProductsAreSimilar() {
        ProductTypePage productTypePage = new HomePage()
                .open()
                .openProductCategoryPage(NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(NOTEBOOKS_CATEGORY);

        int productNumber = 1;
        Product product = productTypePage.getProduct(productNumber);

        String productTitle = product.getProductTitle();
        BigDecimal productPrice = product.getProductPrice();
        String productDescription = product.getProductDescription();

        ProductPage productPage = productTypePage.openProductPage(productNumber);

        String productTitleOnProductPage = productPage.getName();
        BigDecimal productPriceOnProductPage = BigDecimal.valueOf(productPage.getPrice());
        String productDescriptionOnProductPage = productPage.getDescription();

        SoftAssertions softAssertion = new SoftAssertions();
        softAssertion
                .assertThat(productTitle)
                .as("There should be similar titles")
                .isEqualTo(productTitleOnProductPage);
        softAssertion
                .assertThat(productPrice)
                .as("There should be similar price")
                .isEqualTo(productPriceOnProductPage);
        softAssertion
                .assertThat(productDescription)
                .as("There should be similar description")
                .isEqualTo(productDescriptionOnProductPage);
        softAssertion.assertAll();
    }
}
