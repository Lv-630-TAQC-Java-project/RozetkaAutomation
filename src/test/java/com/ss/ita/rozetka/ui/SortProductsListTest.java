package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory;
import com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.pages.ProductTypePage;
import com.ss.ita.rozetka.ui.util.SortType;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class SortingProductsListTest {

    @Test
    public void verifySortingFromCheapToExpensiveTest(){
        ProductTypePage productsList = new HomePage()
                .open()
                .openProductCategoryPage(GeneralProductCategory.COTTAGE_GARDEN_BACKYARD)
                .openProductTypePage(ProductCategoryAndSubCategory.TRIMMERS_SUBCATEGORY)
                .sortProductsListBy(SortType.FROM_CHEAP_TO_EXPENSIVE);
        sleep(10000);
        productsList.sortProductsListBy(SortType.FROM_EXPENSIVE_TO_CHEAP);
        sleep(20000);
    }
}
