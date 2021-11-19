package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.TestUtils.TestRunner;
import com.ss.ita.rozetka.ui.pages.*;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory.HOUSEHOLD_APPLIANCES;
import static com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory.BIG_HOUSEHOLD_APPLIANCES_CATEGORY;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderingProductsTest extends TestRunner {

    @Test
    @Issue("LVTAQC630-28")
    public void verifyOrderingProducts() {
        ProductPage productPage = new HomePage()
                .open()
                .openProductCategoryPage(HOUSEHOLD_APPLIANCES)
                .openProductTypePage(BIG_HOUSEHOLD_APPLIANCES_CATEGORY)
                .openProductPage(1);

        int productPrice = productPage.getPrice();
        String productTitle = productPage.getName();//should be renamed by another PR

        OrderingPage orderingPage = productPage
                .addProductToBasket()
                .orderProducts()
                .sidebarShouldBeVisible();

        int totalPrice = orderingPage.getTotalProductsPrice();
        String orderingProductTitle = orderingPage.getProductTitle();

        assertThat(totalPrice)
                .as("should be the same like productPrice")
                .isEqualTo(productPrice);
        assertThat(productTitle)
                .as("should be the same like ordering product title")
                .isEqualTo(orderingProductTitle);
    }
}