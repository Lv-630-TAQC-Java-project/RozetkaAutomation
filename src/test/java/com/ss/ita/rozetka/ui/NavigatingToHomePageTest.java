package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.pages.ProductCategoryPage;
import com.ss.ita.rozetka.ui.runner.TestRunner;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory.PRODUCTS_FOR_HOUSE;
import static com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory.KITCHEN_APPLIANCES_CATEGORY;

public class NavigatingToHomePageTest extends TestRunner {

    @Test
    public void verifyReturnToHomePage() {
        ProductCategoryPage page = new HomePage().open()
                .openProductCategoryPage(PRODUCTS_FOR_HOUSE);
        String productCategoryUrl = page
                .getHeader()
                .getCurrentUrl();
        Assert.assertEquals(productCategoryUrl, "https://bt.rozetka.com.ua/");
        String productSubcategoryUrl = page
                .openProductTypePage(KITCHEN_APPLIANCES_CATEGORY)
                .getHeader()
                .getCurrentUrl();
        Assert.assertEquals(productSubcategoryUrl, "https://bt.rozetka.com.ua/tehnika-dlya-kuhni/c435974/");
        String homePageUrl = page
                .getHeader()
                .openHomePage()
                .getHeader()
                .openHomePage()
                .getHeader()
                .getCurrentUrl();
        Assert.assertEquals(homePageUrl, "https://rozetka.com.ua/");
    }
}
