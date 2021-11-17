package com.ss.ita.pageobject;

import com.ss.ita.rozetka.ui.TestUtils.TestRunner;
import com.ss.ita.rozetka.ui.pages.*;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory.PRODUCTS_FOR_HOUSE;
import static com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory.BIG_HOUSEHOLD_APPLIANCES_CATEGORY;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderingProductsTest extends TestRunner {

    @Test
    public void verifyOrderingProducts() {
        ProductPage productPage = new HomePage()
                .open()
                .openProductCategoryPage(PRODUCTS_FOR_HOUSE)
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
