package com.ss.ita.rozetka;

import com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory;
import com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.ui.pages.HomePage;
import org.testng.annotations.Test;

public class BasketTest {
    @Test
    public void verifyAddButtonFunctionality() {
        new HomePage().open().openProductCategoryPage(GeneralProductCategory.NOTEBOOKS_AND_COMPUTERS)
                .openProductTypePage(ProductCategoryAndSubCategory.NOTEBOOK_CATEGORY)
                .openProductPage(0)
                .addProductToBasket()
                .increaseAmountOfProductPerUnit();
    }
}
