package com.ss.ita.rozetka.ui;

import com.ss.ita.rozetka.ui.pages.HomePage;
import com.ss.ita.rozetka.ui.pages.ProductCategoryPage;
import com.ss.ita.rozetka.ui.TestUtils.TestRunner;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.ss.ita.rozetka.ui.ProductsEnum.GeneralProductCategory.PRODUCTS_FOR_HOUSE;
import static com.ss.ita.rozetka.ui.ProductsEnum.ProductCategoryAndSubCategory.KITCHEN_APPLIANCES_CATEGORY;
import static com.ss.ita.rozetka.ui.util.PageUtil.getCurrentUrl;

public class NavigatingToHomePageTest extends TestRunner {

    @Test
    public void verifyReturnToHomePage() {
        ProductCategoryPage page = new HomePage()
                .open()
                .openProductCategoryPage(PRODUCTS_FOR_HOUSE);
        Assert.assertEquals(getCurrentUrl(), "https://bt.rozetka.com.ua/");
        page.openProductTypePage(KITCHEN_APPLIANCES_CATEGORY);
        Assert.assertEquals(getCurrentUrl(), "https://bt.rozetka.com.ua/tehnika-dlya-kuhni/c435974/");
        page
                .getHeader()
                .openHomePage();
        Assert.assertEquals(getCurrentUrl(), "https://rozetka.com.ua/");
    }
}
