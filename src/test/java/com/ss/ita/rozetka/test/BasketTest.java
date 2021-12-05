package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.modals.BasketModal;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.ProductPage;
import com.ss.ita.rozetka.pageobject.pages.ProductTypePage;
import com.ss.ita.rozetka.pageobject.product.GeneralProductCategory;
import com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.pageobject.utils.PageUtil.getCurrentUrl;
import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest extends TestRunner {
    @Test
    @Description("Verify that user can change count of product in basket and remove it from there.")
    @TmsLink(value = "LVTAQC630-34")
    public void verifyChangingProductCountAndRemovingFromBasket() {
        BasketModal<ProductPage> basket = new HomePage()
                .open()
                .openProductCategoryPage(GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(ProductCategoryAndSubCategory.NOTEBOOKS_CATEGORY)
                .openProductPage(1)
                .addProductToBasket();

        assertThat(basket.isEmpty())
                .as("Basket can not be empty - a product was added")
                .isFalse();

        String productTitle = basket.getProductTitles().get(0);
        int newProductCount = 3;
        int totalPriceBeforeChangingCount = basket.getProductsTotalPrice();

        basket.setProductCount(productTitle, newProductCount);

        assertThat(basket.getProductsTotalPrice())
                .as("Total price should be updated multiplied by %d due to product count changing", newProductCount)
                .isEqualTo(totalPriceBeforeChangingCount * newProductCount);

        basket.removeProduct(productTitle);

        assertThat(basket.isEmpty())
                .as("Basket should be empty - a product was removed")
                .isTrue();
    }
  
    @Test
    @Description("Verify that, after adding two related products to basket, the total price of basket is correct")
    @TmsLink(value = "LVTAQC630-2")
    public void verifyTotalPriceOfTwoProductsIsCorrect() {
        ProductPage productPage = new HomePage()
                .open()
                .openProductCategoryPage(GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(ProductCategoryAndSubCategory.NOTEBOOKS_CATEGORY)
                .openProductPage(1);
        int productPrice = productPage.getPrice();

        ProductPage relatedProductPage = productPage
                .addProductToBasket()
                .close()
                .openRelatedProduct(1);
        int relatedProductPrice = relatedProductPage.getPrice();

        int expectedTotalPrice = productPrice + relatedProductPrice;
        int actualTotalPrice = relatedProductPage
                .addProductToBasket()
                .getProductsTotalPrice();

        assertThat(actualTotalPrice)
                .as("Total price of products in basket should be equal to sum of their prices")
                .isEqualTo(expectedTotalPrice);
    }

    @Test
    public void verifyAddProductFunctionality() {
        ProductTypePage productTypePage = new HomePage()
                .open()
                .openProductCategoryPage(GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(ProductCategoryAndSubCategory.NOTEBOOKS_CATEGORY);

        assertThat(getCurrentUrl())
                .as("Notebooks subcategory page should be opened")
                .contains("https://rozetka.com.ua/notebooks/c80004/");

        BasketModal<ProductPage> basketModal = productTypePage
                .openProductPage(1)
                .addProductToBasket();

        int priceBeforeIncreasing = basketModal.getProductsTotalPrice();
        assertThat(priceBeforeIncreasing)
                .as("Price of the product shouldn't be equal to 0")
                .isNotEqualTo(0);
        basketModal
                .increaseAmountOfProduct(1, 1)
                .getProductsTotalPrice();

        assertThat(basketModal.getProductsTotalPrice())
                .as("Price after increasing should be changed")
                .isNotEqualTo(priceBeforeIncreasing);
    }
}
