package com.ss.ita.rozetka.test;

import com.google.common.collect.Ordering;
import com.ss.ita.rozetka.pageobject.pages.*;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.pageobject.product.GeneralProductCategory.*;
import static com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory.*;
import static com.ss.ita.rozetka.pageobject.utils.ProductsListSortType.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SortProductsListTest extends TestRunner {

    @Test
    @TmsLink(value = "LVTAQC630-29")
    @Description(value = "Verify sorting functionality from cheap to expensive")
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
}
