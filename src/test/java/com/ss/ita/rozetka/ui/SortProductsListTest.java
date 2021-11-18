package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory;
import com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.ui.TestUtils.TestRunner;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.pages.ProductTypePage;
import com.ss.ita.rozetka.ui.util.ProductsListSortType;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.sleep;
import static org.assertj.core.api.Assertions.assertThat;

public class SortProductsListTest extends TestRunner {

    @Test
    public void verifyFromCheapToExpensiveSortingTest(){
        ProductTypePage productsList = new HomePage()
                .open()
                .openProductCategoryPage(GeneralProductCategory.COTTAGE_GARDEN_BACKYARD)
                .openProductTypePage(ProductCategoryAndSubCategory.TRIMMERS_SUBCATEGORY)
                .sortProductsListBy(ProductsListSortType.FROM_CHEAP_TO_EXPENSIVE);
        int numberProductsListPage = 3;
        List<BigDecimal> actualOrderPrices = productsList
                .openProductsListPage(numberProductsListPage)
                .getProductsListPrices();
        for (BigDecimal price : actualOrderPrices) {
            System.out.print(price + ", ");
        }
        System.out.println("\n" + actualOrderPrices.size());
        List<BigDecimal> expectedOrderPrices = actualOrderPrices
                .stream()
                .sorted()
                .collect(Collectors.toList());
        for (BigDecimal price : expectedOrderPrices) {
            System.out.print(price + ", ");
        }
        System.out.println("\n" + expectedOrderPrices.size());
        assertThat(actualOrderPrices)
                .as("Products list should be sorted")
                .isEqualTo(expectedOrderPrices);
    }
}
