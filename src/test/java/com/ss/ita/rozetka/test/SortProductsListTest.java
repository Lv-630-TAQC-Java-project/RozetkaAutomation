package com.ss.ita.rozetka.test;

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

        int numberProductsListPage = 3;
        List<BigDecimal> actualProductsListPrices = new HomePage()
                .open()
                .openProductCategoryPage(GeneralProductCategory.COTTAGE_GARDEN_BACKYARD)
                .openProductTypePage(ProductCategoryAndSubCategory.TRIMMERS_SUBCATEGORY)
                .sortProductsListBy(ProductsListSortType.CHEAP_TO_EXPENSIVE)
                .openProductsListPage(numberProductsListPage)
                .getProductPricesList();
        List<BigDecimal> expectedProductsListPrices = actualProductsListPrices
                .stream()
                .sorted()
                .collect(Collectors.toList());
        assertThat(actualProductsListPrices)
                .as("Products list prices shout be sorted")
                .isEqualTo(expectedProductsListPrices);
    }
}
