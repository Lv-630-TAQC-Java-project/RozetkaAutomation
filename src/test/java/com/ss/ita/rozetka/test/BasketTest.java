package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.elements.Header;
import com.ss.ita.rozetka.pageobject.modals.BasketModal;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.ProductPage;
import com.ss.ita.rozetka.pageobject.pages.ProductTypePage;
import com.ss.ita.rozetka.pageobject.product.GeneralProductCategory;
import com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.pageobject.utils.PageUtil.getCurrentUrl;
import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest extends TestRunner {
    @Test
    public void verifyTotalPriceOfTwoProductsIsCorrect(){
        HomePage homePage = new HomePage().open();
        
        ProductPage firstProductPage = homePage
                .openProductCategoryPage(GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(ProductCategoryAndSubCategory.NOTEBOOKS_CATEGORY)
                .openProductPage(1);
        int firstProductPrice = firstProductPage.getPrice();

        firstProductPage.addProductToBasket().close();

        ProductPage secondProductPage = firstProductPage
                .openRelatedProductPage(1);
        int secondProductPrice = secondProductPage.getPrice();

        int expectedTotalPrice = firstProductPrice + secondProductPrice;
        int actualTotalPrice = secondProductPage
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

        BasketModal basketModal = productTypePage
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
