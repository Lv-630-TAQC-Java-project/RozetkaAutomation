package com.ss.ita.rozetka.test;

import com.ss.ita.rozetka.pageobject.pages.ProductCategoryPage;
import com.ss.ita.rozetka.pageobject.pages.ProductTypePage;
import com.ss.ita.rozetka.pageobject.product.GeneralProductCategory;
import com.ss.ita.rozetka.pageobject.product.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.pageobject.utils.TestRunner;
import com.ss.ita.rozetka.pageobject.pages.HomePage;
import com.ss.ita.rozetka.pageobject.utils.ProductsListSortType;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SortProductsListTest extends TestRunner {

    @Test
    public void verifyCheapToExpensiveSorting() {

        ProductCategoryPage productCategoryPage = new HomePage()
                .open()
                .openProductCategoryPage(GeneralProductCategory.COTTAGE_GARDEN_BACKYARD);
        assertThat(productCategoryPage.isOpened())
                .as("Products category page should be opened")
                .isTrue();
        ProductTypePage productTypePage = productCategoryPage
                .openProductTypePage(ProductCategoryAndSubCategory.TRIMMERS_SUBCATEGORY);
        assertThat(productTypePage.isOpened())
                .as("Products type page should be opened")
                .isTrue();
        int numberProductsListPage = 3;
        productTypePage
                .sortProductsListBy(ProductsListSortType.CHEAP_TO_EXPENSIVE)
                .openProductsListPage(numberProductsListPage);
        assertThat(productTypePage.isOpened())
                .as("Product type page by should number products list page be opened")
                .isTrue();
        List<BigDecimal> actualProductsListPrices = productTypePage.getProductPricesList();
        List<BigDecimal> expectedProductsListPrices = actualProductsListPrices
                .stream()
                .sorted()
                .collect(Collectors.toList());
        assertThat(actualProductsListPrices)
                .as("Products list prices shout be sorted")
                .isEqualTo(expectedProductsListPrices);
    }
}
