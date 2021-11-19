package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.modals.BasketModal;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.pages.ProductTypePage;
import com.ss.ita.rozetka.pageobject.product.GeneralProductCategory;
import com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.pageobject.utils.PageUtil.getCurrentUrl;
import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest {
    @Test
    public void verifyAddProductFunctionality() {
        ProductTypePage productTypePage = new HomePage()
                .open()
                .openProductCategoryPage(GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(ProductCategoryAndSubCategory.NOTEBOOKS);

        assertThat(getCurrentUrl())
                .as("Notebooks subcategory page should be opened")
                .contains("https://rozetka.com.ua/notebooks/c80004/");

        BasketModal basketModal = productTypePage
                .openProductPage(1)
                .addProductToBasket();

        int priceBeforeIncreasing = basketModal.getTotalProductsPrice();
        assertThat(priceBeforeIncreasing)
                .as("Price of the product shouldn't be equal to 0")
                .isNotEqualTo(0);
        basketModal
                .increaseAmountOfProduct(1, 1)
                .continueBuying()
                .getHeader()
                .openBasketModal()
                .getTotalProductsPrice();

        assertThat(basketModal.getTotalProductsPrice())
                .as("Price after increasing should be changed")
                .isNotEqualTo(priceBeforeIncreasing);
    }
}
