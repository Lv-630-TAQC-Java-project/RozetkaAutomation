package com.ss.ita.rozetka.test;

import com.google.common.collect.Ordering;
import com.ss.ita.rozetka.pageobject.pages.*;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.*;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.TRIMMERS_SUBCATEGORY;
import static com.ss.ita.rozetka.pageobject.utils.ProductsListSortType.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SortProductsListTest extends TestRunner {

    @Test
    @Issue("LVTAQC630-29")
    @Description("Verify sorting functionality from cheap to expensive")
    public void verifyCheapToExpensiveSorting() {
        ProductCategoryPage productCategoryPage = new HomePage()
                .open()
                .openGeneralProductCategory(COTTAGE_GARDEN_BACKYARD);
        assertThat(productCategoryPage.isOpened())
                .as("Products category page should be opened")
                .isTrue();
        ProductTypePage productTypePage = productCategoryPage
                .openProductCategoryAndSubCategory(TRIMMERS_SUBCATEGORY);
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
}
