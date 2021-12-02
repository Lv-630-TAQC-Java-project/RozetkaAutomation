package com.ss.ita.rozetka.test;

import com.google.common.collect.Ordering;
import com.ss.ita.rozetka.pageobject.elements.Product;
import com.ss.ita.rozetka.pageobject.pages.*;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;

import java.util.List;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.*;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.*;
import static com.ss.ita.rozetka.pageobject.utils.ProductsListSortType.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SortProductsListTest extends TestRunner {

    @Test
    @Issue("LVTAQC630-29")
    @Description("Verify sorting functionality from cheap to expensive")
    public void verifyCheapToExpensiveSorting() {
        ProductCategoryPage productCategoryPage = new HomePage()
                .open()
                .openProductCategoryPage(COTTAGE_GARDEN_BACKYARD);
        assertThat(productCategoryPage.isOpened())
                .as("Products category page should be opened")
                .isTrue();
        ProductTypePage productTypePage = productCategoryPage
                .openProductTypePage(TRIMMERS_SUBCATEGORY);
        assertThat(productTypePage.isOpened())
                .as("Products type page should be opened")
                .isTrue();
        productTypePage
                .sortProductsListBy(CHEAP_TO_EXPENSIVE)
                .openProductsListPage(3);
        assertThat(productTypePage.isOpened())
                .as("Product type page by number products list should be opened")
                .isTrue();
        boolean isProductsListPricesSorted = Ordering
                .natural()
                .isOrdered(productTypePage.getProductPricesList());
        assertThat(isProductsListPricesSorted)
                .as("Product prices list should be sorted")
                .isTrue();
    }

    @Test
    @Issue("LVTAQC630-33")
    @Description("Verify that sort by Action products list contains products which have higher old price" +
            " than price with discount and price text color is grey for without price, red for price with discount")
    public void verifyActionSorting() {
        ProductCategoryPage productCategoryPage = new HomePage()
                .open()
                .openProductCategoryPage(SMARTPHONE_TV_ELECTRONICS);
        assertThat(productCategoryPage.isOpened())
                .as("Product category page should be opened")
                .isTrue();
        ProductTypePage productTypePage = productCategoryPage
                .openProductTypePage(MOBILE_PHONES_CATEGORY);
        assertThat(productTypePage.isOpened())
                .as("Product type page should be opened")
                .isTrue();
        productTypePage.sortProductsListBy(ACTION);
        List<Product> promoPriceProductsList = productTypePage.getActionPriceProductsList();
        for (Product promoPriceProduct : promoPriceProductsList) {
            assertThat(promoPriceProduct.isProductDiscountPriceValid())
                    .as("Price with discount must be less than price without discount")
                    .isTrue();
            assertThat(promoPriceProduct.getOldPriceTextColor())
                    .as("Price color text must be grey: #797878")
                    .isEqualTo("#797878");
            assertThat(promoPriceProduct.getPriceTextColor())
                    .as("Price color text must be red: #f84147")
                    .isEqualTo("#f84147");
        }
    }
}


