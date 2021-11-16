package com.ss.ita.rozetka.ui.Modals;

import com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory;
import com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory;
import com.ss.ita.rozetka.ui.pages.HomePage;
import org.testng.annotations.Test;

public class BasketModalTest {
    @Test
    public  void testItWorks(){
        new HomePage()
                .open()
                .openProductCategoryPage(GeneralProductCategory.COTTAGE_GARDEN_BACKYARD)
                .openProductTypePage(ProductCategoryAndSubCategory.GARDEN_EQUIP_CATEGORY)
                .openProductPage(0)
                .addProductToBasket()
                .close()
                .;
    }
}