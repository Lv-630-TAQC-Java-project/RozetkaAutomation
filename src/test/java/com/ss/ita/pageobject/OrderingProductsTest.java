package com.ss.ita.pageobject;

import com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory;
import com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.ui.TestUtils.TestRunner;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.pages.OrderingPage;
import com.ss.ita.rozetka.ui.pages.ProductPage;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory.PRODUCTS_FOR_HOUSE;
import static com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory.GARDEN_EQUIP_CATEGORY;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderingProductsTest extends TestRunner {

    @Test
    public void verifyOrderingProducts() {
        ProductPage productPage = new HomePage()
                .open()
                .openProductCategoryPage(PRODUCTS_FOR_HOUSE)
                .openProductTypePage(GARDEN_EQUIP_CATEGORY)
                .openProductPage(1);

        int productPrice = productPage.getPrice();

        OrderingPage orderingPage = productPage
                .addProductToBasket()
                .orderProducts();

        assertThat(orderingPage.isApproveOrderButtonDisplayed())
                .as("Approve order button should be displayed")
                .isTrue();

        int totalPrice = orderingPage.getTotalProductsPrice();

        assertThat(totalPrice)
                .as("should be the same like productPrice")
                .isEqualTo(productPrice);
    }
}
